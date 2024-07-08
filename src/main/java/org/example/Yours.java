//package org.example;
//
//public class Yours {
//    @PostMapping(value = "/contacts/{conId}/accounts")
//    @Operation(summary = "Save account propagation data")
//    @Deprecated
//    @ApiResponses({@ApiResponse(responseCode = "201", description = "Success")})
//    public ResponseEntity<SaveAccountPropagationResponse> updateAccount(
//            @PathVariable(required = true) @NotNull BigDecimal conId,
//            @RequestHeader(value = "sysid", required = false)
//            @Pattern(regexp = SYSID_APPNAME_PATTERN)
//            String sysId,
//            @RequestHeader(value = "appname", required = false)
//            @Pattern(regexp = SYSID_APPNAME_PATTERN)
//            String appName,
//            @Valid @RequestBody SaveAccountPropagationInput acctPropagationInput) {
//        final String METHOD_NAME = "updateAccount";
//        SaveAccountPropagationResponse response = new SaveAccountPropagationResponse();
//        UpdateCustActCtgServiceOut conResp = null;
//        UpdateCustActCtgServiceOut acctResp = null;
//        List<Account> accountList = null;
//        HttpEntity<List<Account>> accountRespEntity;
//
//        try {
//            StatLoggerUtil.logRequestInfo("PARTITION : ",acctPropagationInput.getPartition());
//            StatLoggerUtil.logRequestInfo("OFFSET : ",acctPropagationInput.getOffset());
//
//            Set<String> fields = new HashSet<>();
//
//
//            LOGGER.debug("Before making the get accounts for conId call");
//            if (pilot.isEnabled(AccountsConstants.Acct_SVC_CALL_PILOT_KEY)) {
//                //Adding the new call for Gna Accounts-svc to get the Accounts info based on a ConID
//                accountList = accountServiceHelper.getAccountsByContactId(conId, acctPropagationInput.getConCtryCd());
//            } else {
//                fields.add("basic");
//                fields.add("suitability");
//                fields.add("roles");
//                fields.add("finra");
//                accountRespEntity = getAccountsForConId(conId, acctPropagationInput.getConCtryCd(), fields);
//                accountList = accountRespEntity.getBody();
//            }
//            StatLoggerUtil.logRequestInfo(CON_ID, conId.toString());
//            Map<BigDecimal, Contact> conIdContactMap = null;
//            if (!CollectionUtils.isEmpty(accountList)) {
//                StatLoggerUtil.logRequestInfo(ACCOUNT_COUNT, String.valueOf(accountList.size()));
//                if (pilot.isEnabled(AccountsConstants.PARALLEL_PILOT_KEY)) {
//                    List<String> conIdList = accountUtil.buildConIdList(accountList);
//                    conIdContactMap = conClient.getConIdContactMap(conIdList);
//                }
//            } else {
//                StatLoggerUtil.logRequestInfo(ACCOUNT_COUNT, String.valueOf(0));
//            }
//            String rvsnUid = acctPropagationInput.getCicsUidCd();
//
//            String cicsUserId = getCicsUserId(rvsnUid);
//
//            acctPropagationInput.setCicsUidCd(cicsUserId);
//
//
//            if (AccountsConstants.ISO_CTRY_CD_US.equals(acctPropagationInput.getConCtryCd())) {
//                UpdateCustActCtgServiceIn ctgIn = acctSaveCtgMapper.mapContactData(acctPropagationInput);
//
//                if (acctSaveCtgMapper.propagateContactChanges(ctgIn, acctPropagationInput)) {
//                    //update contact only fields
//                    conResp = udateCustActCtgSvc.updateCustAcct(ctgIn);
//
//                    LOGGER.info("MF RetCd for contact:"+ acctPropagationInput.getConId() +"save is " + conResp.getReturnCd()
//                            + "MF RetMsg for contact save is " + conResp.getReturnMsg() + ".");
//                    if (!"00".equals(conResp.getReturnCd())) {
//                        LOGGER.error("Return Code from GNAOC616 for contact: "+ acctPropagationInput.getConId() +" update is " + conResp.getReturnCd()
//                                + "Return message from GNAOC616 for contact update is " + conResp.getReturnMsg() + " .");
//                    }
//                }
//
//
//                if (null != accountList && !accountList.isEmpty()) {
//                    List<AcctData> acctDataList = null;
//                    if (pilot.isEnabled(AccountsConstants.PARALLEL_PILOT_KEY)) {
//                        acctDataList = acctSaveCtgMapper.mapAccountData(acctPropagationInput, accountList, conIdContactMap);
//                    } else {
//                        acctDataList = acctSaveCtgMapper.mapAccountData(acctPropagationInput, accountList);
//                    }
//                    for (int i = 0; i < acctDataList.size(); i += 10) {
//
//                        UpdateCustActCtgServiceIn ctgInAcct = new UpdateCustActCtgServiceIn();
//                        List<AcctData> subAcctDataList = acctDataList.subList(i, Math.min(acctDataList.size(), i + 10));
//                        ctgInAcct.setAcctDataList(subAcctDataList);
//                        ctgInAcct.setCicsUidCd(cicsUserId);
//                        ctgInAcct.setFaNo(Integer.valueOf(acctPropagationInput.getFaNo()));
//                        ctgInAcct.setFunctionCd("ACCT");
//                        ctgInAcct.setInCallingApp(acctPropagationInput.getInCallingApp());
//
//                        LOGGER.debug("Calling GNAOC616 with acct level changes");
//                        //update fields for both contact and accounts
//                        acctResp = udateCustActCtgSvc.updateCustAcct(ctgInAcct);
//
//
//                        LOGGER.info("MF RetCd for Account save is " + acctResp.getReturnCd()
//                                + "MF RetMsg for Account save is " + acctResp.getReturnMsg() + " .");
//
//                        if (!"00".equals(acctResp.getReturnCd())) {
//                            LOGGER.error(
//                                    "Return Code from GNAOC616 for account list update is " + acctResp.getReturnCd()
//                                            + "Return message from GNAOC616 for account list update is "
//                                            + acctResp.getReturnMsg() + ".");
//                        }
//                    }
//                    accountsSvc.savePhoneUpdates(acctPropagationInput, accountList);
//
//                    if (null != acctResp && "00".equals(acctResp.getReturnCd())) {
//
//                        if (pilot.isEnabled(AccountsConstants.PARALLEL_PILOT_KEY)) {
//                            LOGGER.info("\nupdateAccountData pilot");
//                            if (conIdContactMap != null) {
//                                accountsUpdateSvc.updateAccountData(accountList, acctPropagationInput, rvsnUid, sysId, appName, conIdContactMap);
//                            } else {
//                                LOGGER.error("The conIdContactMap is null");
//                            }
//                        } else {
//                            LOGGER.info("\nupdateAccountData not pilot");
//                            accountsSvc.updateAccountData(accountList, acctPropagationInput, rvsnUid);
//                        }
//                        for (Account acct : accountList) {
//                            acctsHazelcastCacheSvc.clearHazelcastCacheForAccount(acct.getAcctId());
//                        }
//                    }
//                }
//
//            } else {
//
//                if (null != accountList && !accountList.isEmpty()) {
//
//                    if (pilot.isEnabled(AccountsConstants.PARALLEL_PILOT_KEY)) {
//                        LOGGER.info("\nupdateAccountData pilot");
//                        if (conIdContactMap != null) {
//                            accountsUpdateSvc.updateAccountData(accountList, acctPropagationInput, rvsnUid, sysId, appName, conIdContactMap);
//                        } else {
//                            LOGGER.error("The conIdContactMap is null");
//                        }
//                    } else {
//                        accountsSvc.updateAccountData(accountList, acctPropagationInput, rvsnUid);
//                    }
//
//
//                    UpdateW9 updateW9Obj = accountsSvc.buildUpdateW9Obj(acctPropagationInput);
//                    if (null != updateW9Obj) {
//
//                        accountsSvc.updateW9Indicator(updateW9Obj, accountList);
//                    }
//
//                    for (Account acct : accountList) {
//                        acctsHazelcastCacheSvc.clearHazelcastCacheForAccount(acct.getAcctId());
//                    }
//                }
//            }
//        } catch (AccountSaveException e) {
//            throw new AccountRetrievalException(e.getMessage());
//        } catch (Exception e) {
//            LinkedHashMap<String, String> logParams = new LinkedHashMap<>();
//            logParams.put("CLASS_NAME", this.getClass().getSimpleName());
//            logParams.put("METHOD_NAME", METHOD_NAME);
//            logParams.put("conId", String.valueOf(conId));
//            String errorMessage = CommonUtil.buildErrorMessage(
//                    sysId,
//                    appName,
//                    "CriticalTypeException$" + e.getClass().getSimpleName(),
//                    logParams,
//                    "Error occurred while saving account data - " + e.getMessage(),
//                    null,
//                    null
//            );
//            LOGGER.error(errorMessage);
//        }
//
//        return new ResponseEntity(response, HttpStatus.OK);
//    }
//}

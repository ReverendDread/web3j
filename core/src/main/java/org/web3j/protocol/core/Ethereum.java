/*
 * Copyright 2019 Web3 Labs Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.web3j.protocol.core;

import java.math.BigInteger;
import java.util.List;

import org.web3j.protocol.core.methods.request.ShhFilter;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.core.methods.response.admin.AdminDataDir;
import org.web3j.protocol.core.methods.response.admin.AdminNodeInfo;
import org.web3j.protocol.core.methods.response.admin.AdminPeers;

/** Core Ethereum JSON-RPC API. */
public interface Ethereum {
    Request<?, Web3ClientVersion> web3ClientVersion();

    Request<?, Web3Sha3> web3Sha3(String data);

    Request<?, NetVersion> netVersion();

    Request<?, NetListening> netListening();

    Request<?, NetPeerCount> netPeerCount();

    Request<?, AdminNodeInfo> adminNodeInfo();

    Request<?, AdminPeers> adminPeers();

    Request<?, BooleanResponse> adminAddPeer(String url);

    Request<?, BooleanResponse> adminRemovePeer(String url);

    Request<?, AdminDataDir> adminDataDir();

    Request<?, EthProtocolVersion> ethProtocolVersion();

    Request<?, EthChainId> ethChainId();

    Request<?, EthCoinbase> ethCoinbase();

    Request<?, EthSyncing> ethSyncing();

    Request<?, EthMining> ethMining();

    Request<?, EthHashrate> ethHashrate();

    Request<?, EthGasPrice> ethGasPrice();

    Request<?, EthMaxPriorityFeePerGas> ethMaxPriorityFeePerGas();

    Request<?, EthFeeHistory> ethFeeHistory(
            int blockCount, DefaultBlockParameter newestBlock, List<Double> rewardPercentiles);

    Request<?, EthAccounts> ethAccounts();

    Request<?, EthBlockNumber> ethBlockNumber();

    Request<?, EthGetBalance> ethGetBalance(
            String address, DefaultBlockParameter defaultBlockParameter);

    Request<?, EthGetStorageAt> ethGetStorageAt(
            String address, BigInteger position, DefaultBlockParameter defaultBlockParameter);

    Request<?, EthGetTransactionCount> ethGetTransactionCount(
            String address, DefaultBlockParameter defaultBlockParameter);

    Request<?, EthGetBlockTransactionCountByHash> ethGetBlockTransactionCountByHash(
            String blockHash);

    Request<?, EthGetBlockTransactionCountByNumber> ethGetBlockTransactionCountByNumber(
            DefaultBlockParameter defaultBlockParameter);

    Request<?, EthGetUncleCountByBlockHash> ethGetUncleCountByBlockHash(String blockHash);

    Request<?, EthGetUncleCountByBlockNumber> ethGetUncleCountByBlockNumber(
            DefaultBlockParameter defaultBlockParameter);

    Request<?, EthGetCode> ethGetCode(String address, DefaultBlockParameter defaultBlockParameter);

    Request<?, EthSign> ethSign(String address, String sha3HashOfDataToSign);

    Request<?, org.web3j.protocol.core.methods.response.EthSendTransaction> ethSendTransaction(
            org.web3j.protocol.core.methods.request.Transaction transaction);

    Request<?, org.web3j.protocol.core.methods.response.EthSendTransaction> ethSendRawTransaction(
            String signedTransactionData);

    Request<?, org.web3j.protocol.core.methods.response.EthCall> ethCall(
            org.web3j.protocol.core.methods.request.Transaction transaction,
            DefaultBlockParameter defaultBlockParameter);

    Request<?, EthEstimateGas> ethEstimateGas(
            org.web3j.protocol.core.methods.request.Transaction transaction);

    Request<?, EthBlock> ethGetBlockByHash(String blockHash, boolean returnFullTransactionObjects);

    Request<?, EthBlock> ethGetBlockByNumber(
            DefaultBlockParameter defaultBlockParameter, boolean returnFullTransactionObjects);

    Request<?, EthTransaction> ethGetTransactionByHash(String transactionHash);

    Request<?, EthTransaction> ethGetTransactionByBlockHashAndIndex(
            String blockHash, BigInteger transactionIndex);

    Request<?, EthTransaction> ethGetTransactionByBlockNumberAndIndex(
            DefaultBlockParameter defaultBlockParameter, BigInteger transactionIndex);

    Request<?, EthGetTransactionReceipt> ethGetTransactionReceipt(String transactionHash);

    Request<?, EthBlock> ethGetUncleByBlockHashAndIndex(
            String blockHash, BigInteger transactionIndex);

    Request<?, EthBlock> ethGetUncleByBlockNumberAndIndex(
            DefaultBlockParameter defaultBlockParameter, BigInteger transactionIndex);

    Request<?, EthGetCompilers> ethGetCompilers();

    Request<?, EthCompileLLL> ethCompileLLL(String sourceCode);

    Request<?, EthCompileSolidity> ethCompileSolidity(String sourceCode);

    Request<?, EthCompileSerpent> ethCompileSerpent(String sourceCode);

    Request<?, EthFilter> ethNewFilter(org.web3j.protocol.core.methods.request.EthFilter ethFilter);

    Request<?, EthFilter> ethNewBlockFilter();

    Request<?, EthFilter> ethNewPendingTransactionFilter();

    Request<?, EthUninstallFilter> ethUninstallFilter(BigInteger filterId);

    Request<?, EthLog> ethGetFilterChanges(BigInteger filterId);

    Request<?, EthLog> ethGetFilterLogs(BigInteger filterId);

    Request<?, EthLog> ethGetLogs(org.web3j.protocol.core.methods.request.EthFilter ethFilter);

    Request<?, EthGetWork> ethGetWork();

    Request<?, EthSubmitWork> ethSubmitWork(String nonce, String headerPowHash, String mixDigest);

    Request<?, EthSubmitHashrate> ethSubmitHashrate(String hashrate, String clientId);

    Request<?, EthProof> ethGetProof(String address, List<String> storageKeys, DefaultBlockParameter defaultBlockParameter);

    Request<?, DbPutString> dbPutString(String databaseName, String keyName, String stringToStore);

    Request<?, DbGetString> dbGetString(String databaseName, String keyName);

    Request<?, DbPutHex> dbPutHex(String databaseName, String keyName, String dataToStore);

    Request<?, DbGetHex> dbGetHex(String databaseName, String keyName);

    Request<?, org.web3j.protocol.core.methods.response.ShhPost> shhPost(
            org.web3j.protocol.core.methods.request.ShhPost shhPost);

    Request<?, ShhVersion> shhVersion();

    Request<?, ShhNewIdentity> shhNewIdentity();

    Request<?, ShhHasIdentity> shhHasIdentity(String identityAddress);

    Request<?, ShhNewGroup> shhNewGroup();

    Request<?, ShhAddToGroup> shhAddToGroup(String identityAddress);

    Request<?, ShhNewFilter> shhNewFilter(ShhFilter shhFilter);

    Request<?, ShhUninstallFilter> shhUninstallFilter(BigInteger filterId);

    Request<?, ShhMessages> shhGetFilterChanges(BigInteger filterId);

    Request<?, ShhMessages> shhGetMessages(BigInteger filterId);

    Request<?, TxPoolStatus> txPoolStatus();
}

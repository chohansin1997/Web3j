package org.web3j;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.generated.contracts.HelloWorld;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.DefaultBlockParameterNumber;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * <p>This is the generated class for <code>web3j new helloworld</code></p>
 * <p>It deploys the Hello World contract in src/main/solidity/ and prints its address</p>
 * <p>For more information on how to run this project, please refer to our <a href="https://docs.web3j.io/quickstart/#deployment">documentation</a></p>
 */
public class Web3App {

  public static Web3j web3 = Web3j.build(new HttpService("http://127.0.0.1:7545"));
  public static String walletAddress = "0xA18B65a08AA032c83d267a8A16507D32d42ae786";
  public static String privateKey = "d939c843930502e3fb40ceadfdf08511a6493eed48b372b2547a20e9cd5ec718";

  public static void main(String[] args) throws Exception {

    Web3ClientVersion clientVersion = web3.web3ClientVersion().send();

    //eth_blockNumber returns the number of most recent block.
    EthBlockNumber blockNumber = web3.ethBlockNumber().send();

    //eth_gasPrice, returns the current price per gas in wei.
    EthGasPrice gasPrice = web3.ethGasPrice().send();

    System.out.println("Client version: " + clientVersion.getWeb3ClientVersion());
    System.out.println("Block number: " + blockNumber.getBlockNumber());
    System.out.println("Gas price: " + gasPrice.getGasPrice());

    System.out.println();

    EthGetBalance balanceTest = web3.ethGetBalance(walletAddress, new DefaultBlockParameterNumber(5)).send();
    // DefaultBlockParameterNumber 데이터를 조회할 블럭의 index 설정
    //만약 해당 지갑에 블럭 4 일때 100 이더를 보낸다면 블럭 5를 조회해야 기존 이더에 100증가된 값이 조회됨 4를 조회시 여전히 이전 값이 조회

    EthGetBalance balance = web3.ethGetBalance(walletAddress, DefaultBlockParameterName.LATEST).send();
    //제일 최신 블럭 가져오기

    BigDecimal balanceInEther = Convert.fromWei(balance.getBalance().toString(), Convert.Unit.ETHER);
    System.out.println(balanceInEther);

    //계정의 nonce 가져오기
    // 계정 상태에는 계정에서 수행한 트랜잭션 수를 상징하는 일련 번호인 nonce 가 포함됩니다.
    EthGetTransactionCount ethGetTransactionCount = web3.ethGetTransactionCount(walletAddress, DefaultBlockParameterName.LATEST).send();
    BigInteger nonce = ethGetTransactionCount.getTransactionCount();

    System.out.println(nonce);
  }
}


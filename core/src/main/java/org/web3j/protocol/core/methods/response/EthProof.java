package org.web3j.protocol.core.methods.response;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.web3j.protocol.ObjectMapperFactory;
import org.web3j.protocol.core.Response;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

/**
 * <p>See <a href="https://eips.ethereum.org/EIPS/eip-1186"></a>docs</p>
 * for further details.
 */
public class EthProof extends Response<EthProof.Proof> {

    @Override
    @JsonDeserialize
    public void setResult(EthProof.Proof result) {
        super.setResult(result);
    }

    public EthProof.Proof getProof() {
        return getResult();
    }

    public static class Proof {

        private List<String> accountProof;
        private String balance;
        private String codeHash;
        private String nonce;
        private String storageHash;
        private List<StorageProof> storageProof;

        public Proof() {}

        public Proof(
                List<String> accountProof,
                String balance,
                String codeHash,
                String nonce,
                String storageHash,
                List<StorageProof> storageProof) {
            this.accountProof = accountProof;
            this.balance = balance;
            this.codeHash = codeHash;
            this.nonce = nonce;
            this.storageHash = storageHash;
            this.storageProof = storageProof;
        }

        public List<String> getAccountProof() {
            return accountProof;
        }

        public String getBalanceRaw() {
            return balance;
        }

        public BigInteger getBalance() {
            return Numeric.decodeQuantity(balance);
        }

        public String getCodeHash() {
            return codeHash;
        }

        public String getNonceRaw() {
            return nonce;
        }

        public BigInteger getNonce() {
            return Numeric.decodeQuantity(nonce);
        }

        public String getStorageHash() {
            return storageHash;
        }

        public List<StorageProof> getStorageProof() {
            return storageProof;
        }

        public void setAccountProof(List<String> accountProof) {
            this.accountProof = accountProof;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public void setCodeHash(String codeHash) {
            this.codeHash = codeHash;
        }

        public void setNonce(String nonce) {
            this.nonce = nonce;
        }

        public void setStorageHash(String storageHash) {
            this.storageHash = storageHash;
        }

        public void setStorageProof(List<StorageProof> storageProof) {
            this.storageProof = storageProof;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Proof proof = (Proof) o;

            if (getAccountProof() != null ? !getAccountProof().equals(proof.getAccountProof()) : proof.getAccountProof() != null)
                return false;
            if (getBalance() != null ? !getBalance().equals(proof.getBalance()) : proof.getBalance() != null)
                return false;
            if (getCodeHash() != null ? !getCodeHash().equals(proof.getCodeHash()) : proof.getCodeHash() != null)
                return false;
            if (getNonce() != null ? !getNonce().equals(proof.getNonce()) : proof.getNonce() != null) return false;
            if (getStorageHash() != null ? !getStorageHash().equals(proof.getStorageHash()) : proof.getStorageHash() != null)
                return false;
            return getStorageProof() != null ? getStorageProof().equals(proof.getStorageProof()) : proof.getStorageProof() == null;
        }

        @Override
        public int hashCode() {
            int result = getAccountProof() != null ? getAccountProof().hashCode() : 0;
            result = 31 * result + (getBalance() != null ? getBalance().hashCode() : 0);
            result = 31 * result + (getCodeHash() != null ? getCodeHash().hashCode() : 0);
            result = 31 * result + (getNonce() != null ? getNonce().hashCode() : 0);
            result = 31 * result + (getStorageHash() != null ? getStorageHash().hashCode() : 0);
            result = 31 * result + (getStorageProof() != null ? getStorageProof().hashCode() : 0);
            return result;
        }

    }

    public static class StorageProof {
        private String key;
        private List<String> proof;
        private String value;

        public StorageProof() {}

        public StorageProof(String key, List<String> proof, String value) {
            this.key = key;
            this.proof = proof;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public List<String> getProof() {
            return proof;
        }

        public String getValueRaw() {
            return value;
        }

        public BigInteger getValue() {
            return Numeric.decodeQuantity(value);
        }

        public void setKey(String key) {
            this.key = key;
        }

        public void setProof(List<String> proof) {
            this.proof = proof;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

}

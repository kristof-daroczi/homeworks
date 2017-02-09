package xyz.codingmentor.web.jpa.hw.war.dto;

/**
 *
 * @author Krisz
 * @param <T>
 */
public class ResultDTO<T> {

    private ResultType result;
    private T message;

    public ResultDTO() {
        //empty on purpose
    }

    public ResultDTO(ResultType result, T message) {
        this.result = result;
        this.message = message;
    }

    public ResultType getResult() {
        return result;
    }

    public void setResult(ResultType result) {
        this.result = result;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}
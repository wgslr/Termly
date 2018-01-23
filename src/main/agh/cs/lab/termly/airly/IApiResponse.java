package agh.cs.lab.termly.airly;

public interface IApiResponse {
    /**
     * Checks if returned data contain no values
     *
     * @return True iff there are no meaningfull data in the api response
     */
    boolean isEmpty();
}

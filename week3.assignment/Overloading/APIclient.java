package week3.assignment;

public class APIclient {
	public void sendRequest(String endpoint) {
		System.out.println("Endpoint:"+endpoint);
	}
	public void sendRequest(String endpoint,String requestBody,boolean requestStatus) {
		System.out.println("Endpoint is:"+endpoint + " " + "Data:"+requestBody + " " + "Status:"+requestStatus);
	}

	public static void main(String[] args) {
		APIclient apc = new APIclient();
		apc.sendRequest("www.ajio.com");
		apc.sendRequest("www.amazon.com", "Data collected", true);

	}

}

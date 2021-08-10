import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

public class WeatherService
{
   String CityName;	
	public JSONObject getWeather()
	{
			try 
		{
		 var url ="http://api.weatherapi.com/v1/current.json?key=e3ac81bc8fd84b7cb4461201210308&q="+getCityName()+"&aqi=no";
	     var request=HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
	     var client = HttpClient.newBuilder().build();
	     var response=client.send(request, HttpResponse.BodyHandlers.ofString());
	     return new JSONObject(response.body());	 
	  //   JSONObject jsnobj=new JSONObject(store).getJSONObject("location");
	    //  String s1=jsnobj.getString("name");
	      //System.out.println("name  :  "+ s1);
	     }
			
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return  null;
	   }
	public JSONObject getLocation()
	{
		JSONObject locationobj=getWeather().getJSONObject("location");
		return locationobj;
	}
	public JSONObject getCurrent()
	{
		JSONObject currentobj=getWeather().getJSONObject("current");
		return currentobj;
	}

	private String getCityName() {
		// TODO Auto-generated method stub
		return CityName;
	}

	public String setCityName(String cityname) {
		// TODO Auto-generated method stub
		CityName=cityname;
		return cityname;
	}
}
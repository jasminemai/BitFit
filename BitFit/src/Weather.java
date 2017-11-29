import de.mbenning.weather.wunderground.api.domain.DataSet;
import de.mbenning.weather.wunderground.api.domain.WeatherStation;
import de.mbenning.weather.wunderground.api.domain.WeatherStations;
import de.mbenning.weather.wunderground.impl.services.HttpDataReaderService;

public class Weather {

	public static void main(String[] args) {
		
		WeatherStation aWeatherStation = new WeatherStation("KSCSOUTH12");

		HttpDataReaderService dataReader = new HttpDataReaderService();
		dataReader.setWeatherStation(aWeatherStation );
		System.out.println(aWeatherStation.getStationId());
		Double currentTemperature = dataReader.getCurrentData().getTemperature();
		//System.out.println(currentTemperature);
	}

}

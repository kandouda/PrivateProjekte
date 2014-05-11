package de.khaled.example.soap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

public class GeoIp {
	public static void main(String[] args) {
		GeoIPService geoIpService = new GeoIPService();
		GeoIPServiceSoap geoIpSoap = geoIpService.getGeoIPServiceSoap();
		
		while(true){
		System.out.println("Geben Sie die Ip-Addresse: ");
		String ipAddress = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			ipAddress = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		GeoIP geoIP = geoIpSoap.getGeoIP(ipAddress);
		
		System.out.println("Your country is " + geoIP.getCountryName());
		}
	}
}

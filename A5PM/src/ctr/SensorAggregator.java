package ctr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.*;

public class SensorAggregator implements Comparator<String> {

	List<SensorAggregator> inputList = new ArrayList<SensorAggregator>();
	static String path = "C:\\Users\\Dizzle\\Desktop\\Informatik\\4.Semester\\Programmiermodelle\\Aufgaben\\A5\\jena.csv";
	static double max;

	public SensorAggregator(String path) {
		this.path = path;
	}

	public static double getMax(String sensorName, String from, String to) throws IOException {

		BufferedReader csvReader = new BufferedReader(new FileReader(path));
		String firstLine = csvReader.readLine();
		int spalteName = 0;
		int ifSpalteName = 0;
		boolean isValidSensorName = false;

		for (String s : firstLine.split(",")) { // Extrahiere Position vom Sensorname

			if (s.equalsIgnoreCase("\"" + sensorName + "\"")) {
				ifSpalteName = spalteName;
				isValidSensorName = true;
			}
			spalteName++;
		}

		if (!isValidSensorName) {
			System.err.println("wrong Sensorname...");
			return 0.00;
		}

		System.out.println(ifSpalteName);
		final int finalInt = ifSpalteName;

		@SuppressWarnings("resource")
		Stream<String> names = Files.lines(Paths.get(path)); // Initialisiere Stream mit angegebenen Path

		DoubleSummaryStatistics maxDouble = names.sorted().skip(1).filter(x -> {
			try {
				return SensorAggregator.isInRangeDateFormat(x, from, to);// Wenn x in Datumsbeschränkung liegt
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return false;
		}).map(s -> s.split(",")[finalInt]).mapToDouble(Double::valueOf).summaryStatistics();

		final double max = maxDouble.getMax() * 100;

		return max;
	}

	@Override
	public int compare(String o1, String o2) {
		return 0;
	}

	public static boolean isInRangeDateFormat(String dataIn, String from, String to) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

		Date dateIn = sdf.parse(dataIn);
		Date dateFrom = sdf.parse(from);
		Date dateTo = sdf.parse(to);
		if (dateIn.compareTo(dateFrom) >= 0) {
			if (dateIn.compareTo(dateTo) <= 0) {
				return true;
			}
		}
		return false;
	}

}

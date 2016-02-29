package edu.ccai6.cs221;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.ccai6.cs221.dao.HTMLDao;
import edu.ccai6.cs221.dao.IFIDF;
import edu.ccai6.cs221.dao.IFIDFDao;
import edu.ccai6.cs221.dao.TextDao;
import edu.ccai6.cs221.dao.URLDao;

public class QueryProcessor {
	List<String> _tokenList = new ArrayList<String>();
	Map<String, Double> _counter = new HashMap<String, Double>();
	private static final Pattern TITLE_TAG = Pattern.compile("\\<title>(.*)\\</title>",
			Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	private static final int LENGTH = 200;
	private static final int MAX_NUM = 10;

	public QueryProcessor(List<String> _tokenList) {
		super();
		this._tokenList = _tokenList;
	}

	public QueryProcessor() {
		super();
	}

	public List<String> get_tokenList() {
		return _tokenList;
	}

	public void add(String token) {
		_tokenList.add(token);
	}

	public String get(int i) {
		return _tokenList.get(i);
	}

	private static List<Map.Entry<String, Double>> sortByComparator(Map<String, Double> unsortMap) {

		// Convert Map to List
		List<Map.Entry<String, Double>> list = new LinkedList<Map.Entry<String, Double>>(unsortMap.entrySet());

		// Sort list with comparator, to compare the Map values
		Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
			public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
				return 0-(o1.getValue()).compareTo(o2.getValue());
			}
		});

//		// Convert sorted map back to a Map
//		Map<String, Double> sortedMap = new LinkedHashMap<String, Double>();
//		for (Iterator<Map.Entry<String, Double>> it = list.iterator(); it.hasNext();) {
//			Map.Entry<String, Double> entry = it.next();
//			sortedMap.put(entry.getKey(), entry.getValue());
//		}
		return list;
	}

	public List<Result> rank(IFIDFDao ifidfDao, URLDao urlDao, TextDao textDao, HTMLDao htmlDao) {
		// First, do the computation
		for (String token : _tokenList) {
			String value = ifidfDao.getIFIDF(token).get_value();
			String[] list = value.split(",");
			for (String item : list) {
				String[] pair = item.split(":");
				String docID = pair[0];
				Double count = Double.parseDouble(pair[1]);
				if (_counter.containsKey(docID)) {
					// Has this doc
					count += _counter.get(docID);
					_counter.put(docID, count);
				} else {
					// Does not have this doc
					_counter.put(docID, count);
				}
			}
		}
		// Second, sort the hashmap by count
		List<Map.Entry<String, Double>> sortedList = sortByComparator(_counter);

		// Third, conver the hashmap to result
		String title;
		String url;
		String paragraph;
		List<Result> rslList = new ArrayList<Result>();
		int count = 0;
		for (Map.Entry<String, Double> item : sortedList) {
			String docId = item.getKey();
			String rank = ""+item.getValue();
			if (count >= MAX_NUM) break;
			// First, get the title
			String html = htmlDao.getHTML(docId).get_html();
			// extract the title
			Matcher matcher = TITLE_TAG.matcher(html);
			if (matcher.find()) {
				title = matcher.group(1).replaceAll("[\\s\\<>]+", " ").trim();
			} else {
				title = "No title";
			}
			
			// Second, get the url;
			url = urlDao.getURL(docId).get_url();
			
			// Third, get the paragraph;
			paragraph = textDao.getText(docId).get_text().replaceAll(" ", "").replaceAll("\t", "").substring(0, LENGTH)+"...";
			rslList.add(new Result(title, url, paragraph, rank));
			count++;
		}
		return rslList;
	}
}

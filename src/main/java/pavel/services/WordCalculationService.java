package pavel.services;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by kalpak44 on 21.01.17.
 */
@Component
public class WordCalculationService {
    @Value("${words.ignore.list}")
    private String ignoreJsonString;

    // TODO: 22.01.17 fix problem with encoding
    @Value("${words.split.pattern}")
    private String splitPattern;

    public Map<String, Integer> calculateWordsCount(final String text) {
        final Map<String, Integer> result = new HashMap<>();
        final String[] words = text.split(splitPattern);

        for (final String word : words) {
            if (!hasInIgnoreList(word) && !word.isEmpty()) {
                addWordToMap(result, word);
            }
        }

        return sortByValue(result);
    }

    private void addWordToMap(final Map<String, Integer> result, final String word) {
        if (result.get(word) != null) {
            result.put(word, result.get(word) + 1);
        } else {
            result.put(word, 1);
        }
    }


    private boolean hasInIgnoreList(final String word) {
        final JSONArray ignoreList = new JSONArray(ignoreJsonString);
        for (int i = 0; i < ignoreList.length(); i++) {
            if (ignoreList.getString(i).toLowerCase().equals(word.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    private <K, V extends Comparable<? super V>> Map<K, V> sortByValue(final Map<K, V> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

}

package b314.S2TextEditor.action;

import b314.S2TextEditor.model.SearchResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SearchActions {

    private boolean useRegexFlag;

    private List<SearchResult> searchResults;

    private int currentResultIndex;

    boolean switchRegexFlag() {
        useRegexFlag = !useRegexFlag;
        return useRegexFlag;
    }

    SearchResult search(String content, String target) {
        searchResults = new ArrayList<>();
        currentResultIndex = -1;
        if (useRegexFlag) {
            searchByMatch(content, target);
        } else {
            searchSubstring(content, target);
        }
        try {
            return searchResults.get(currentResultIndex);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No match present!");
            return null;
        }
    }

    private void searchSubstring(String content, String target) {
        if ("".equals(target)) {
            return;
        }

        f(content, target, 0);

        if (!searchResults.isEmpty()) {
            currentResultIndex = 0;
        }
    }

    private void f(String content, String target, int offset) {
        if (target.length() > content.length()) {
            return;
        }

        int index = content.indexOf(target);

        if (index == -1) {
            return;
        }

        searchResults.add(new SearchResult(index + offset, target));

        int nextOffset = index + offset + target.length();
        f(content.substring(index + target.length()), target, nextOffset);
    }

    private void searchByMatch(String content, String regex) {
        Pattern target = Pattern.compile(regex);
        Matcher matcher = target.matcher(content);
        while (matcher.find()) {
            searchResults.add(new SearchResult(matcher.start(), matcher.group()));
        }

        if (!searchResults.isEmpty()) {
            currentResultIndex = 0;
        }
    }

    SearchResult previousMatch() {
        if (currentResultIndex != -1) {
            currentResultIndex--;
        }
        if (currentResultIndex < 0) {
            currentResultIndex = searchResults.size() - 1;
        }
        try {
            return searchResults.get(currentResultIndex);
        } catch (Exception e) {
            System.out.println("No match present!");
            return null;
        }
    }

    SearchResult nextMatch() {
        if (currentResultIndex != -1) {
            currentResultIndex++;
        }
        if (currentResultIndex >= searchResults.size()) {
            currentResultIndex = 0;
        }
        try {
            return searchResults.get(currentResultIndex);
        } catch (Exception e) {
            System.out.println("No match present!");
            return null;
        }
    }

}

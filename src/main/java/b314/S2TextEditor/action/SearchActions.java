package b314.S2TextEditor.action;

import b314.S2TextEditor.model.SearchResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implements search-related actions, like
 * search in file, match results iterating, regex usage etc.
 */
@Service
public class SearchActions {

    // To indicate regex usage
    private boolean useRegexFlag;

    // List to store search results
    private final List<SearchResult> searchResults = new ArrayList<>();

    // Index of current (selected) match
    private int currentResultIndex;

    /**
     * Switches regex usage
     * true -> false
     * false -> true
     * @return updated flag value
     */
    public boolean switchRegexFlag() {
        useRegexFlag = !useRegexFlag;
        return useRegexFlag;
    }

    /**
     * Searches for target in content
     * Type of search (substring or regex) is defined by useRegexFlag
     * @param content String to search in
     * @param target substring or regex to search for
     * @return 1st match result (if found)
     * @throws IndexOutOfBoundsException if no match found
     */
    public SearchResult search(String content, String target) throws IndexOutOfBoundsException {
        // Clearing old results
        searchResults.clear();

        // Resetting current result index
        currentResultIndex = -1;

        // Deciding for search type
        if (useRegexFlag) {
            // Searching by regex
            searchByRegex(content, target);
        } else {
            // Searching by substring
            searchSubstring(content, target);
        }

        // Checking for currentResultIndex update
        if (!searchResults.isEmpty()) {
            // There are matches -> current result index is 0
            currentResultIndex = 0;
        }

        // Returning
        return searchResults.get(currentResultIndex);
    }

    /**
     * Implements substring search
     * @param content String to search IN
     * @param target String to search FOR (exactly)
     */
    private void searchSubstring(String content, String target) {
        // Empty check
        if ("".equals(target)) {
            return;
        }

        // Recursive search
        f(content, target, 0);
    }

    /**
     * Recursively runs substring search:
     * Adds 1st occurrence of target in content, calls itself with offset on content
     * @param content String to search in
     * @param target String to search for
     * @param offset accumulator to calculate match position in original string
     */
    private void f(String content, String target, int offset) {
        // target longer than content -> no match left, return
        if (target.length() > content.length()) {
            return;
        }

        // Getting 1st occurrence
        int index = content.indexOf(target);

        if (index == -1) {
            // No match, return
            return;
        }

        // Adding new match to list
        searchResults.add(new SearchResult(index + offset, target));

        // Recursion
        int nextOffset = index + offset + target.length();
        f(content.substring(index + target.length()), target, nextOffset);
    }

    /**
     * Implements search by regex
     * @param content String to search in
     * @param regex to search with
     */
    private void searchByRegex(String content, String regex) {
        // Creating matcher
        Matcher matcher = Pattern.compile(regex).matcher(content);

        // Searching
        while (matcher.find()) {
            searchResults.add(new SearchResult(matcher.start(), matcher.group()));
        }
    }

    /**
     * Previous match getter (relative to current)
     * @return previous match
     * @throws IndexOutOfBoundsException if no match was originally found
     */
    public SearchResult previousMatch() throws IndexOutOfBoundsException {
        if (currentResultIndex != -1) {
            currentResultIndex--;
        }
        if (currentResultIndex < 0) {
            currentResultIndex = searchResults.size() - 1;
        }
        return searchResults.get(currentResultIndex);
    }

    /**
     * Next match getter (relative to current)
     * @return next match
     * @throws IndexOutOfBoundsException if no match was originally found
     */
    public SearchResult nextMatch() throws IndexOutOfBoundsException {
        if (currentResultIndex != -1) {
            currentResultIndex++;
        }
        if (currentResultIndex >= searchResults.size()) {
            currentResultIndex = 0;
        }
        return searchResults.get(currentResultIndex);
    }

}

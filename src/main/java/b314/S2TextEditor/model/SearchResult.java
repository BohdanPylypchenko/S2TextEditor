package b314.S2TextEditor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Search result = string + its position in original content.
 * Used for both search by match and search by regex
 */
@AllArgsConstructor
@Getter
public class SearchResult {

    // Position in original content
    private int pos;

    // Result itself
    private String result;

}

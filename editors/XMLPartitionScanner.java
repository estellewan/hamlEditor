package hamleditor.editors;

import org.eclipse.jface.text.rules.*;

public class XMLPartitionScanner extends RuleBasedPartitionScanner {
	public final static String XML_COMMENT = "__xml_comment";
	public final static String XML_TAG = "__xml_tag";
	public final static String HAML_VAR = "__haml_var";

	public XMLPartitionScanner() {

		IToken xmlComment = new Token(XML_COMMENT);
		IToken tag = new Token(XML_TAG);
		IToken variable = new Token(HAML_VAR);

		IPredicateRule[] rules = new IPredicateRule[4];

		rules[0] = new MultiLineRule("<!--", "-->", xmlComment);
		rules[1] = new MultiLineRule("#", "\n", xmlComment);
		rules[2] = new TagRule(tag);
		rules[3] = new MultiLineRule("@"," ",variable);
		
		setPredicateRules(rules);
	}
}

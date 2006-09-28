/*
 * $Id: org.eclipse.jdt.ui.prefs 5004 2006-03-17 20:47:08 -0800 (Fri, 17 Mar
 * 2006) eelco12 $ $Revision$ $Date: 2006-03-17 20:47:08 -0800 (Fri, 17
 * Mar 2006) $
 * 
 * ==============================================================================
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package wicket.markup;

/**
 * Holds markup as a resource (the stream that the markup came from) and a list
 * of MarkupElements (the markup itself).
 * 
 * @see MarkupElement
 * @see ComponentTag
 * @see wicket.markup.RawMarkup
 * 
 * @author Jonathan Locke
 * @author Juergen Donnerstag
 */
public abstract interface IMarkup extends Iterable<MarkupElement>
{
	/** Placeholder that indicates no markup */
	public static final Markup NO_MARKUP = new Markup();

	/**
	 * Find the markup element index of the component with 'path'
	 * 
	 * @param path
	 *            The component path expression
	 * @return -1, if not found
	 */
	int findTag(final String path);

	/**
	 * For Wicket it would be sufficient for this method to be package
	 * protected. However to allow wicket-bench easy access to the information
	 * ...
	 * 
	 * @param index
	 *            Index into markup list
	 * @return Markup element
	 */
	MarkupElement get(final int index);

	/**
	 * Gets the markup encoding. A markup encoding may be specified in a markup
	 * file with an XML encoding specifier of the form &lt;?xml ...
	 * encoding="..." ?&gt;.
	 * 
	 * @return Encoding, or null if not found.
	 */
	String getEncoding();

	/**
	 * Gets the resource that contains this markup
	 * 
	 * @return The resource where this markup came from
	 */
	MarkupResourceStream getResource();

	/**
	 * Get the wicket namespace valid for this specific markup
	 * 
	 * @return wicket namespace
	 */
	String getWicketNamespace();

	/**
	 * Return the XML declaration string, in case if found in the markup.
	 * 
	 * @return Null, if not found.
	 */
	String getXmlDeclaration();

	/**
	 * Get the markup fragments associated with the markup file
	 * 
	 * @return Tree of MarkupFragments and RawMarkup
	 */
	MarkupFragment getMarkupFragments();

	/**
	 * For Wicket it would be sufficient for this method to be package
	 * protected. However to allow wicket-bench easy access to the information
	 * ...
	 * 
	 * @return Number of markup elements
	 */
	int size();

	/**
	 * Make all markup fragment modifiable.
	 * 
	 * @param emptyCopy
	 *            If true, do NOT copy the markup elements
	 * @return Markup
	 */
	Markup mutable(boolean emptyCopy);

	/**
	 * Make all markup fragmends unmodifable.
	 */
	void makeImmutable();

	/**
	 * @return String representation of markup list
	 */
	String toDebugString();

	/**
	 * @return String representation of markup list
	 */
	String toString();
}
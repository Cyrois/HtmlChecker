import java.util.LinkedList;
import java.util.Queue;

/*
 * This is the HtmlValidator class.
 * You should implement this class.
 */
public class HtmlValidator {
	private Queue<HtmlTag> validator;

	/**
	 * Requires: nothing
	 * Effects: creates a new empty queue
	 */
	public HtmlValidator() {
		this.validator = new LinkedList<HtmlTag>();
	}

	/**
	 * Requires: The queue passed in to be a valid queue of HtmlTags
	 * Effects: creates a new copy of the queue that was passed
	 * 
	 * @param tags The queue to be copied
	 * @throws IllegalArugmentException if the passed queue is null
	 */
	public HtmlValidator(Queue<HtmlTag> tags) throws IllegalArgumentException {
		if (tags == null) {
			throw new IllegalArgumentException("The queue is null");
		} else {
			this.validator = new LinkedList<HtmlTag>();
			for (HtmlTag tag : tags) {
				this.validator.add(tag.clone());
			}
		}
	}

	/**
	 * Requires: nothing 
	 * Effects: Adds given tag to the end of the validator
	 * queue.
	 * 
	 * @param tag The HtmlTag to be added to the queue
	 * @throws an IllegalArgumentException if the tag is null
	 */
	public void addTag(HtmlTag tag) throws IllegalArgumentException {
		if (tag == null) {
			throw new IllegalArgumentException("The tag passed is null");
		} else {
			this.validator.add(tag);
		}
	}

	/**
	 * Requires: nothing
	 * Effects: returns a copy queue of the current validator 
	 * 
	 * @return a copy of the current validator queue
	 */
	public Queue<HtmlTag> getTags() {
		Queue<HtmlTag> returnQueue = new LinkedList<HtmlTag>();

		for (HtmlTag tag : this.validator) {
			returnQueue.add(tag.clone());
		}

		return returnQueue;
	}

	/**
	 * Requires: the passed string to be a valid html element
	 * Effects: removes all opening and closing tags of the passed element 
	 * from the current validator.
	 * 
	 * @param element The element to be removed from the queue
	 */
	@SuppressWarnings("unused")
	public void removeAll(String element) throws IllegalArgumentException {
		if (element.isEmpty() && element == null) {
			throw new IllegalArgumentException("The element passed is null");
		} else {
			HtmlTag elementOpenTag = new HtmlTag(element);

			while (this.validator.contains(elementOpenTag)) {
				this.validator.remove(elementOpenTag);
			}

			HtmlTag elementCloseTag = new HtmlTag(element, false);

			while (this.validator.contains(elementCloseTag)) {
				this.validator.remove(elementCloseTag);
			}
		}
	}

	/**
	 * Requires: nothing
	 * Effects: Prints an indented text representation of the
	 * HTML tags in the current queue. The indentation is represented
	 * with 4 spaces.
	 * 
	 */
	public void validate() {
		int numSpacing = 0;
		MyStack openTagsStack = new MyStack();

		for (HtmlTag currentTag : this.validator) {
			if (currentTag.isSelfClosing()) {
				if (currentTag.toString().charAt(1) == '/') {
					printUnexpectedTag(currentTag);
				} else {
					printTag(numSpacing, currentTag);
				}
			} else if (currentTag.isOpenTag() && !currentTag.isSelfClosing()) {
				printTag(numSpacing, currentTag);
				openTagsStack.push(currentTag);
				numSpacing++;
			} else {
				if (!openTagsStack.isEmpty()) { // if the stack is not empty
					HtmlTag lastOpenTag = openTagsStack.peek();
					if (lastOpenTag.matches(currentTag)) {
						numSpacing--;
						printTag(numSpacing, currentTag);
						openTagsStack.pop();
					} else {
						printUnexpectedTag(currentTag);
					}
				} else {
					printUnexpectedTag(currentTag);
				}
			}
		}

		while (!openTagsStack.isEmpty()) {
			System.out.print("ERROR unclosed tag: "
					+ openTagsStack.pop().toString() + "\r\n");
		}
	}

	/**
	 * Requires: nothing
	 * Effects: Prints the given tag to with a specified number of indents to the console.
	 * 
	 * @param indents The number of indents before the tag
	 * @param tag The tag to be printed to the console
	 */
	public void printTag(int indents, HtmlTag tag) {
		String spacing = "    "; // 4 spaces for indentation
		String outputString = "";

		for (int i = 0; i < indents; i++) {
			outputString = outputString.concat(spacing);
		}
		outputString = outputString.concat(tag.toString() + "\r\n");
		System.out.print(outputString);
	}

	/**
	 * Requires: nothing
	 * Effects: Prints the given tag with an error message
	 * 
	 * @param tag The unexpected tag to be printed.
	 */
	public void printUnexpectedTag(HtmlTag tag) {
		System.out.print("ERROR unexpected tag: " + tag.toString() + "\r\n");
	}

}

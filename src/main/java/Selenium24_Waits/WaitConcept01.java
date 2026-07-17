package Selenium24_Waits;

public class WaitConcept01 {

	public static void main(String[] args) {
		/**
		 * wait --> synchronization between script and app
		 * 2 types of wait
		 * 
		 * 1. static wait: Thread.sleep(10000) -- available in java library
		 * 		It applies the pause to the execution for specified time
		 * 		Say element is available in 2 sec, given wait is 10 sec, the script will be paused for 10 sec
		 * 		Say element will be visible after 15sec, but script will only wait for 10sec. Then tries executing the next step.
		 * 
		 * 2. Dynamic wait: 2 types (selenium waits)
		 * Eg: Timeout applied is 10 sec and element is find within 2sec, the script will continue execution after 2 secs.
		 *     Timeout is 10 secs; element is visible after 15sec; then it gives timeout
		 *  2.1. Implicitly wait
		 *  2.2. Explicit wait
		 *  	2.2.1. WebDriverWait
		 *  	2.2.2. FluentWait
		 */

	}

}

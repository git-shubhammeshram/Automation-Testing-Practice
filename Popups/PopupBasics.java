package Popups;

public class PopupBasics {

	/*
	 * It is small notifications windows which is shows error messages, success
	 * messages, or any notifications while we perform any action on any component
	 * present in web-page.
	 * 
	 * We cannot inspect or cannot handle popups normally. For handle popups we need
	 * to switch selenium focus from main page to alert popups Alert is an interface
	 * First we need to switch to alert and driver.switchTo().alert(); then store an
	 * instence of Alert interface For accept :- accept(); For decline :- dismiss();
	 */
	/*
	 * Types of Alert:-
	 * 1.Hidden division
	 * 2.Alert Division
	 * 3.Child Browser
	 * 4.Authentication
	 * 5.File Upload
	 * 6.File Download
	 * 
	 */
	/*
	 * 1.Hidden Division:-
	 * We can inspect element present in popups
	 * We cannot drag and drop these popups.
	 * These popups are colorfull.
	 * 
	 * 2.Alert Popup
	 * We cannot inspect element present in popup
	 * We can drag and drop these popup
	 * It maay contain Ok, Cancel, Symbol Or Text
	 * 
	 * 3.Child Browser
	 * We can inspect , drag and drop contain add,max,min,options.
	 * 
	 * 4.Authenticaation
	 * 5.File Upload
	 * 6.File Download
	 * 
	 * For these types of popups handling we need to third party tool Autolt or Robot Class  
	 */
}

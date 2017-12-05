package com.ul.project.support;

import com.ul.project.dao.CarSupportDAO;
import com.ul.project.dto.FeedbackDetail;

// TODO: Auto-generated Javadoc
/**
 * The Class SaveFeedback.
 */
public class SaveFeedback {

	/**
	 * Saving feedback.
	 *
	 * @param title the title
	 * @param description the description
	 * @throws Exception the exception
	 */
	public void savingFeedback(String title,String description ) throws Exception {
		FeedbackDetail fbd = new FeedbackDetail();
		fbd.setTitle(title);
		fbd.setDescription(description);
		new CarSupportDAO().savingFeebdback(fbd);
	}

}

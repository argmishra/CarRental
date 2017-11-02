package com.ul.project.support;

import com.ul.project.dao.CarSupportDAO;
import com.ul.project.dto.FeedbackDetail;

public class SaveFeedback {

	public void savingFeebdback(String title,String description ) throws Exception {
		FeedbackDetail fbd = new FeedbackDetail();
		fbd.setTitle(title);
		fbd.setDescription(description);
		new CarSupportDAO().savingFeebdback(fbd);
	}

}

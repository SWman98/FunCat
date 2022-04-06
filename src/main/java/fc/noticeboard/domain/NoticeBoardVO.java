package fc.noticeboard.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeBoardVO {

/*	
	create table NOTICE  (  
			   NOTICE_NUM NUMBER not null primary key, 
			   NOTICE_SUB VARCHAR2(200) not null, 
			   NOTICE_CON VARCHAR2(700) not null, 
			   NOTICE_DATE DATE DEFAULT SYSDATE, 
			   NOTICE_VIEW NUMBER not null
			);

*/

	private int notice_num;
	private String notice_sub;
	private String notice_con;
	private Date notice_date;
	private int notice_view;
}

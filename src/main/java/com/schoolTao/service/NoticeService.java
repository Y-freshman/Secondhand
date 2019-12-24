package com.schoolTao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolTao.dao.NoticeMapper;
import com.schoolTao.pojo.Notice;
import com.schoolTao.pojo.NoticeExample;
import com.schoolTao.pojo.Notice;

@Service
public class NoticeService {

	@Autowired
	NoticeMapper noticeMapper;

	public int InsertNotice(Notice notice) {
		// TODO Auto-generated method stub
		int i = noticeMapper.insertSelective(notice);//插入，可部分插入
		return i;
	}
	

	public List<Notice> SelectNotice() {
		NoticeExample noti = new NoticeExample();
		noti.createCriteria().andNoticeTypeEqualTo("0");
		List<Notice> noticelist = noticeMapper.selectByExample(noti);
		
		return noticelist;
	}


	public List<Notice> getNotice(Integer page, Integer limit) {
		// TODO Auto-generated method stub
		return noticeMapper.selectByLimit(page,limit);
	}

	public Long countNotice() {
		// TODO Auto-generated method stub
		return noticeMapper.countByExample(null);
	}

	public void deleteNotice(Integer noticeId) {
		// TODO Auto-generated method stub
		noticeMapper.deleteByPrimaryKey(noticeId);
	}

	public void batchDelNotice(List<Integer> cidLst) {
		// TODO Auto-generated method stub
		for(int i=0; i<cidLst.size(); i++){
			noticeMapper.deleteByPrimaryKey(cidLst.get(i));
		}
	}
	
	
	
}

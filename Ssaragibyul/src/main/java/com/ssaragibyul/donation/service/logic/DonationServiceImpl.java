package com.ssaragibyul.donation.service.logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssaragibyul.common.PageInfo;
import com.ssaragibyul.common.Reply;
import com.ssaragibyul.donation.domain.Donation;
import com.ssaragibyul.donation.domain.DonationComments;
import com.ssaragibyul.donation.domain.DonationFile;
import com.ssaragibyul.donation.domain.DonationLike;
import com.ssaragibyul.donation.domain.DonationLog;
import com.ssaragibyul.donation.domain.DonationReport;
import com.ssaragibyul.donation.service.DonationService;
import com.ssaragibyul.donation.store.DonationStore;
import com.ssaragibyul.point.service.PointService;

@Service
public class DonationServiceImpl implements DonationService{
	
	@Autowired
	private DonationStore dStore;
	
	@Autowired
	private PointService pntService;

	
	// 기부 리스트
	@Override
	public ArrayList<Donation> printAllProject() {
		ArrayList<Donation> dListandFile = dStore.printAllProject();
		return dListandFile;
	}

	@Override
	public ArrayList<Donation> printAllProjectLimit() {
		ArrayList<Donation> dListandFile = dStore.printAllProjectLimit();
		return dListandFile;
	}
	
	// 기부 리스트
	@Override
	public ArrayList<Donation> printAllProjectEnd() {
		ArrayList<Donation> dListandFileEnd = dStore.printAllProjectEnd();
		return dListandFileEnd;
	}
	
	@Override
	public ArrayList<Donation> printAllProjectEndLimit() {
		ArrayList<Donation> dListandFileEnd = dStore.printAllProjectEndLimit();
		return dListandFileEnd;
	}
	
	// 기부 제안 등록
	// 한 개의 컨트롤러에서 두 개의 store메소드 사용, Controller or ServiceImol에서 사용 가능.
	@Override
	public int registerDonation(Donation donation, DonationFile donationFile) {
		int result = dStore.insertDonation(donation);
		int dResult = 0;
		if (result > 0) {
			dResult = dStore.insertDonationFile(donationFile);
		}
		return dResult;
	}
	
	// 기부 참여하기
	@Override
	public int registerDonationLog(Donation donation, DonationLog donationLog) {
		int result = dStore.insertDonationLog(donationLog);
		int dResult = 0;
		int pntResult = 0;
		if (result > 0) {
			dResult = dStore.updateProject_SumMonet(donation);
			if (dResult > 0) {
				pntResult = pntService.registerNegPoint(donationLog);
			}
		}
		return pntResult;
	}
	
	/*
	 * // 기부 상세페이지
	 * 
	 * @Override public int addReadCountHit(int projectNo) { return
	 * dStore.addReadCount(projectNo); }
	 */
	
	
	//기부 상세 페이지
	@Override
	public DonationFile printOneFile(int projectNo) {
		return dStore.selectOneFile(projectNo);
	}
	
	@Override
	public Donation printOne(int projectNo) {
		return dStore.printOne(projectNo);
	}
	
	@Override
	public ArrayList<DonationLike> printOneLike(int projectNo) {
		return dStore.selectOneLike(projectNo);
	}
	
	@Override
	public int addReadCountHit(int projectNo) {
		return dStore.addReadCount(projectNo);
	}
	//////////////////////////

	// 후원자 수 카운트
	@Override
	public DonationLog printSponserNumber(int projectNo) {
		return dStore.selectSponserNumber(projectNo);
	}
	
	// 좋아요 
	@Override
	public int donationLikeRegister(Donation donation, DonationLike donationLike) {
		int result = dStore.updateLike(donation);
		int dResult = 0;
		if (result > 0) {
			dResult = dStore.insertLike(donationLike);
		}
		return dResult;
	}

	// 좋아요 취소
	@Override
	public int donationLikeRemove(Donation donation, DonationLike donationLike) {
		int result = dStore.updateLike_Minus(donation);
		int dResult = 0;
		if (result > 0) {
			dResult = dStore.deleteLike(donationLike);
		}
		return dResult;
	}

	// 
	@Override
	public int addLikeCount(int dProjectNo, DonationLike dLike) {
		return dStore.addLikeCount(dProjectNo, dLike);
	}

	
	// 댓글 작성
	@Override
	public int registerReply(Reply reply) {
		return dStore.insertReply(reply);
	}
	
	// 댓글 목록 출력
	@Override
	public ArrayList<Reply> printAllReply(int projectNo) {
		return dStore.selectAllReply(projectNo);
	}
	
	// 댓글 수정
	@Override
	public int updateReply(Reply reply) {
		return dStore.updateReply(reply);
	}

	// 댓글 삭제
	@Override
	public int deleteReply(Reply reply) {
		return dStore.deleteReply(reply);
	}

	// 금액
	@Override
	public ArrayList<Donation> printAllProjectForMoney() {
		ArrayList<Donation> dListandFile = dStore.printAllProjectByMoney();
		return dListandFile;
	}
	
	// 기부 참여하기
	@Override
	public ArrayList<DonationLog> printDonationLogOne(int projectNo) {
		return dStore.selectDonationLogOne(projectNo);
	}
	
	// 신고하기
	@Override
	public int accusationRegister(DonationReport donationReport) {
		return dStore.accusationInsert(donationReport);
	}
	
	@Override
	public int getListCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Donation> PrintAll(PageInfo pi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifyDonation(Donation donation) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeDonation(int dProjectNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int resisterComment(DonationComments dComments) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<DonationComments> printAllCommnets(int dProjectNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void goalPriceCount(int dProjectNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void achieve(int dProjectNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dateRemain(int dProjectNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void participant(int dProjectNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Donation> printAllRecommend(int dProjectNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifySuggest(Donation donation) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeSuggest(int dProjectNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Donation printOneSuggest(int dProjectNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int removeLike(int dProjectNo, DonationLike dLike) {
		// TODO Auto-generated method stub
		return 0;
	}

}

package model;

import java.util.ArrayList;
import java.util.List;

import dao.BulletinDAO;

public class IndexBulletinLogic {
	public List<Integer> execute() {
		BulletinDAO bulletinDao = new BulletinDAO();
		int countRows = bulletinDao.count();
		int result = (countRows - 1) / 20;
		List<Integer> indexList = new ArrayList<Integer>();
		for (int i = 0; i < result; i++) {
			indexList.add(i);
		}
		return indexList;
	}
}



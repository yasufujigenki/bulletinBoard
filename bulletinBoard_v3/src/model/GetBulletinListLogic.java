package model;
import java.util.List;

import dao.BulletinDAO;
//BulletinDAOを利用してBulletinテーブルの全レコードを取得して、それを返す為のModel
public class GetBulletinListLogic {
	public List<Bulletin> execute(int pageNum) {
		BulletinDAO bulletinDao = new BulletinDAO();
		List<Bulletin> bulletinList = bulletinDao.findAll(pageNum);
		return bulletinList;
	}
}



package model;
import dao.BulletinDAO;
//BulletinDAOを利用して引数のBulletinインスタンスをBulletinテーブルに追加する為のModel
public class PostBulletinLogic {
	public void execute(Bulletin bulletin) {
		BulletinDAO bulletinDao = new BulletinDAO();
		bulletinDao.create(bulletin);
	}
}



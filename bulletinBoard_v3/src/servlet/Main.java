package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Bulletin;
import model.GetBulletinListLogic;
import model.IndexBulletinLogic;
import model.PostBulletinLogic;
import model.User;


@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		if(loginUser == null) {
			response.sendRedirect("/bulletinBoard_v3/");
		} else {
			request.setCharacterEncoding("UTF-8");
			String page = request.getParameter("page");
			int nowPage;
			try {
				nowPage = Integer.parseInt(page);
			} catch (Exception e) {
				nowPage = 0;
			}
			GetBulletinListLogic getBulletinListLogic = new GetBulletinListLogic();
			List<Bulletin> bulletinList = getBulletinListLogic.execute(nowPage * 20);
			IndexBulletinLogic indexBulletinLogic = new IndexBulletinLogic();
			List<Integer> indexList = indexBulletinLogic.execute();
			request.setAttribute("nowPage", nowPage);
			request.setAttribute("bulletinList", bulletinList);
			request.setAttribute("indexList", indexList);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		if(text != null && text.length() != 0) {
			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");
			Bulletin bulletin = new Bulletin(loginUser.getName(), text);
			PostBulletinLogic postBulletinlogic = new PostBulletinLogic();
			postBulletinlogic.execute(bulletin);
		} else {
			request.setAttribute("errorMsg", "コメントが入力されていません");
		}
		GetBulletinListLogic getBulletinListLogic = new GetBulletinListLogic();
		List<Bulletin> bulletinList = getBulletinListLogic.execute(0);
		request.setAttribute("bulletinList", bulletinList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);



	}
}



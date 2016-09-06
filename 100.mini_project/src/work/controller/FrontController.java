package work.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import work.model.dto.Board;
import work.model.dto.User;
import work.model.service.BoardService;
import work.model.service.UserService;
import work.util.Utility;

public class FrontController extends HttpServlet {
	private UserService userService = new UserService();
	private BoardService boardService = new BoardService();
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uId = request.getParameter("uId");
		String uPw = request.getParameter("uPw");
		HashMap <String, String> loginMap = userService.loginUser(uId, uPw);
		
		if(loginMap != null) {
			HttpSession session = request.getSession();
			session.setAttribute("uId", uId);
			session.setAttribute("uName", loginMap.get("name"));
			session.setAttribute("uGrade",loginMap.get("grade"));
			
			if(loginMap.get("grade").equals("A")){
				request.getRequestDispatcher("Controller?action=usersInfo").forward(request, response);
			} else {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("message", "�α��� ����. ID�� ��й�ȣ�� Ȯ�����ּ���.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			
		}
	}
	
	protected void signIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uId = request.getParameter("uId");
		String uPw = request.getParameter("uPw");
		String uName = request.getParameter("name");
		String uEmail = request.getParameter("email1") + request.getParameter("email2");
		String uMobile = request.getParameter("mobile1") + "-"
						+ request.getParameter("mobile2") + "-"
						+ request.getParameter("mobile3");
		int uBirthYear = Integer.parseInt(request.getParameter("birth1"));
		String uBirthMonday = request.getParameter("birth2")+
							 request.getParameter("birth3");
		String uGender=request.getParameter("gender"); 
		String uGrade="G";
		String uEntryDate=Utility.getCurrentDate();
		int uMileage=0;
		
		User dto = new User(uId, uPw, uName, uMobile, uEmail, uGrade, uEntryDate, uMileage, uGender, uBirthYear, uBirthMonday);
		
		int row = userService.insertUser(dto);
		if(row == 1) {
			request.setAttribute("message", "ȸ�����Կ� �����߽��ϴ�.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "ȸ�����Կ� �����߽��ϴ�. ID �� ��Ÿ������ Ȯ�����ּ���.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
	
	protected void findId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uName = request.getParameter("uName");
		String uMobile = request.getParameter("uMobile");
		
		String uId = userService.selectId(uName, uMobile);
		
		if(uId != null) {
			request.setAttribute("uId", uId);
			request.setAttribute("uName", uName);
			request.getRequestDispatcher("findResult.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "�˻��� ȸ���� �������� �ʽ��ϴ�. �ٽ� Ȯ�����ּ���");
			request.getRequestDispatcher("findId.jsp").forward(request, response);
		}
	}
	
	protected void findPw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uId = request.getParameter("uId");
		String uName = request.getParameter("uName");
		String uMobile = request.getParameter("uMobile");
		
		String uPw = userService.selectPw(uId, uName, uMobile);
		
		if(uPw != null) {
			request.setAttribute("uId", uId);
			request.setAttribute("uName", uName);
			request.setAttribute("uPw", uPw);
			request.getRequestDispatcher("findResult.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "�˻��� ȸ���� �������� �ʽ��ϴ�. �ٽ� Ȯ�����ּ���.");
			request.getRequestDispatcher("findPw.jsp").forward(request, response);
		}
	}
	
	protected void myInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String uId = request.getParameter("uId");
		System.out.println("uid:"+uId);
		User dto = null;
		
		if(session != null && session.getAttribute("uId") != null) {
			String suId = (String) session.getAttribute("uId");
			if(uId != null) {
				dto = userService.selectInfo(uId);
				request.setAttribute("dto", dto);
				request.getRequestDispatcher("userInfo.jsp").forward(request, response);
			} else {
				dto = userService.selectInfo(suId);
				request.setAttribute("dto", dto);
				request.getRequestDispatcher("myInfo.jsp").forward(request, response);
			}
			
			
		} else {
			request.setAttribute("message", "�� ���� Ȯ�� ����. �ٽ� �õ����ּ���.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
	
	protected void usersInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		ArrayList<User> list = null;
		if(session != null && session.getAttribute("uId") != null && session.getAttribute("uGrade").equals("A")) {
			list = userService.selectUserList();
			request.setAttribute("list", list);
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		} 
	}
	
	protected void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String uId = request.getParameter("uId");
		
		if(session != null && session.getAttribute("uId") != null) {
			int row = userService.deleteUserAdmin(uId);
			
			if(row == 1) {
				request.setAttribute("message", "ȸ��Ż�� �����߽��ϴ�.");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "ȸ��Ż�� �����߽��ϴ�. �ٽ� �õ����ּ���.");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if(session != null && session.getAttribute("uId") != null) {
			session.removeAttribute("uId");
			session.removeAttribute("uName");
			session.removeAttribute("uGrade");
			session.invalidate();
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "�α׾ƿ� ����. �ٽ� �õ����ּ���.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
	
	protected void boardList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageNum = request.getParameter("pageNum");
		ArrayList<Board> list = boardService.selectBoardList(pageNum);
		
		if(list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("freeBoardList.jsp").forward(request, response);
		}
	}
	
	protected void boardEntry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		HttpSession session = request.getSession(false);
		ServletContext application = getServletContext();
		int sizeLimit = 16 * 1024 * 1024;
		String savePath = application.getRealPath("images");
		
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		
		String bTitle = multi.getParameter("bTitle");
		String bPw = multi.getParameter("bPw");
		String bContent = multi.getParameter("bContent");
		String bAuthor = (String)session.getAttribute("uId");
		String bFile1 = multi.getFilesystemName("bFile1");
		String bFile2 = multi.getFilesystemName("bFile2");
		String bFile3 = multi.getFilesystemName("bFile3");
		String filePath1 = null;
		String filePath2 = null;
		String filePath3 = null; 
		
		if(bFile1 != null) {
			filePath1 = "images"+"\\"+bFile1;
		} 
		if(bFile2 != null) {
			filePath2 = "images"+"\\"+bFile2;
		}
		if(bFile3 != null) {
			filePath3 = "images"+"\\"+bFile3;
		}
				
		if(bTitle != null && bPw != null && bContent != null && bAuthor != null) {
			int row = 0;
			if( session != null && session.getAttribute("uGrade").equals("A")) {
				row = boardService.insertBoard(bTitle, bPw, bContent, bAuthor, filePath1, filePath2, filePath3, 1);
			} else {
				row = boardService.insertBoard(bTitle, bPw, bContent, bAuthor, filePath1, filePath2, filePath3, 0);
			}
			if(row == 1) {
				response.sendRedirect("Controller?action=boardList&pageNum=1");
			} else {
				request.setAttribute("message", "�Խñ� ��� ���� �߻�");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			
		} else {
			request.setAttribute("message", "�ʼ� �Է¶��� ä���ּ���");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
	
	protected void boardSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNum = request.getParameter("boardNum");
		String opt = request.getParameter("opt");
		Board dto = null;
		Cookie[] cookies = request.getCookies();
		Cookie viewCookie = null;
		
		if(cookies != null && cookies.length > 0) {		  
			for(int i = 0; i< cookies.length; i++) {
				if(cookies[i].getName().equals("VCOOKIE")) { 
					viewCookie = cookies[i];
				}
			}  
		}
		
		if(viewCookie == null) {
			System.out.println("VIEWCOOKIE ����");
			Cookie newCookie = new Cookie("VCOOKIE","|"+boardNum+"|"); 
			response.addCookie(newCookie);
			dto = boardService.selectBoard(boardNum, 0);
		} else {
			System.out.println("VIEWCOOKIE ����");
			String value = viewCookie.getValue();
			  
			if(value.indexOf("|"+boardNum+"|") <  0) { 
			   value = value+"|"+boardNum+"|";
			   viewCookie.setValue(value);
			   response.addCookie(viewCookie);
			   dto = boardService.selectBoard(boardNum, 0);
			} else {
			   dto = boardService.selectBoard(boardNum, 1);
			} 	
		}
		
		if(dto != null) {
			request.setAttribute("dto", dto);
			
			if(opt == null) {
				request.getRequestDispatcher("freeBoardItem.jsp").forward(request, response);
			} else if(opt.equals("update")) {
				request.getRequestDispatcher("freeBoardUpdate.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("message", "�Խñ� ��ȸ ����.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
	
	protected void boardUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = getServletContext();
		int sizeLimit = 16 * 1024 * 1024;
		String savePath = application.getRealPath("images");
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		
		String boardNum = multi.getParameter("boardNum");
		String bTitle = multi.getParameter("bTitle");
		String bPw = multi.getParameter("bPw");
		String bContent = multi.getParameter("bContent");
		String bFile1 = multi.getFilesystemName("bFile1");
		String bFile2 = multi.getFilesystemName("bFile2");
		String bFile3 = multi.getFilesystemName("bFile3");
		String filePath1 = null;
		String filePath2 = null;
		String filePath3 = null; 
		
		if(bFile1 != null) {
			filePath1 = "images"+"\\"+bFile1;
		} 
		if(bFile2 != null) {
			filePath2 = "images"+"\\"+bFile2;
		}
		if(bFile3 != null) {
			filePath3 = "images"+"\\"+bFile3;
		}
		int row = boardService.updateBoard(bTitle, bPw, bContent, boardNum, filePath1, filePath2, filePath3);
		
		if(row == 1) {
			request.setAttribute("message", "�Խñ� ���� ����.");
			request.getRequestDispatcher("Controller?action=boardList&pageNum=1").forward(request, response);	
		} else {
			request.setAttribute("message", "�Խñ� ���� ����.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
	
	protected void boardDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNum = request.getParameter("boardNum");
		int row = boardService.deleteBoard(boardNum);
		System.out.println(boardNum);
		if(row == 1) {
			request.setAttribute("message", "�Խñ� ���� ����.");
			request.getRequestDispatcher("Controller?action=boardList&pageNum=1").forward(request, response);	
		} else {
			request.setAttribute("message", "�Խñ� ���� ����.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
	
	protected void boardListSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sType = request.getParameter("sType");
		String sTitle = request.getParameter("sTitle");
		String pageNum = request.getParameter("pageNum");
		
		ArrayList<Board> list = boardService.selectBoardListSearch(pageNum, sType, sTitle);
		
		if(list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("freeBoardList.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "�˻������ �������� �ʽ��ϴ�");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
	
	protected void boardRecommend(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rNum = request.getParameter("rNum");
		String boardNum = request.getParameter("boardNum");
		HttpSession session = request.getSession(false);
		Cookie[] cookies = request.getCookies();
		Cookie viewCookie =null;
		
		if(session.getAttribute("uId") != null) {
			if(cookies != null && cookies.length > 0) {		  
				for(int i = 0; i< cookies.length; i++) {
					if(cookies[i].getName().equals("VIEWCOOKIE")) { 
						viewCookie = cookies[i];
					}
				}  
			}
			if(viewCookie == null) {
				System.out.println("VIEWCOOKIE ����");
				Cookie newCookie = new Cookie("VIEWCOOKIE","|"+boardNum+"|"); //("VIEWCOOKIE"�� name, "|"+bbsno+"|" �� value ��. 
				response.addCookie(newCookie);
				int rows = boardService.updateRecBoard(rNum,boardNum);				
				if(rows == 1) {
					request.setAttribute("message", "��õ �Ϸ�");
					request.getRequestDispatcher("Controller?action=boardSearch&boardNum"+boardNum).forward(request, response);
				} else {
					request.setAttribute("message", "��õ ����.");
					request.getRequestDispatcher("Controller?action=boardSearch&boardNum"+boardNum).forward(request, response);
				}
			} else {
				System.out.println("VIEWCOOKIE ����");
				String value = viewCookie.getValue();
				  
				if(value.indexOf("|"+boardNum+"|") <  0) { // �Է��� ��ȭ�� ��ġ�ϴ� ��ȣ�� ������ �߰��Ѵ�.
				   value = value+"|"+boardNum+"|";
				   viewCookie.setValue(value);
				   response.addCookie(viewCookie);
				   int rows = boardService.updateRecBoard(rNum,boardNum);				
				   if(rows == 1) {
						request.setAttribute("message", "��õ �Ϸ�");
						request.getRequestDispatcher("Controller?action=boardSearch&boardNum"+boardNum).forward(request, response);
				   } else {
						request.setAttribute("message", "��õ ����.");
						request.getRequestDispatcher("Controller?action=boardSearch&boardNum"+boardNum).forward(request, response);
				   }
				} else {
					request.setAttribute("message", "��õ �ߺ��� �Ұ����մϴ�.");
					request.getRequestDispatcher("Controller?action=boardSearch&boardNum"+boardNum).forward(request, response);
				} 	
			}
		} else {
			request.setAttribute("message", "��õ ����. �α��� �� �ٽ� �õ����ּ���.");
			request.getRequestDispatcher("Controller?action=boardSearch&boardNum"+boardNum).forward(request, response);
		}
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("action : "+ action);
		
		switch(action) {
			case "login":
				login(request,response);
				break;
			case "signIn":
				signIn(request,response);
				break;
			case "logout":
				logout(request, response);
				break;
			case "findId":
				findId(request, response);
				break;
			case "findPw":
				findPw(request, response);
				break;
			case "myInfo":
				myInfo(request, response);
				break;
			case "usersInfo":
				usersInfo(request, response);
				break;
			case "deleteUser":
				deleteUser(request, response);
				break;
			case "boardList":
				boardList(request, response);
				break;
			case "boardEntry":
				boardEntry(request, response);
				break;
			case "boardSearch":
				boardSearch(request, response);
				break;
			case "boardDelete":
				boardDelete(request, response);
				break;
			case "boardUpdate":
				boardUpdate(request, response);
				break;
			case "boardListSearch":
				boardListSearch(request, response);
				break;
			case "boardRecommend":
				boardRecommend(request, response);
				break;
			default:
				break;
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		process(request,response);
	}

}

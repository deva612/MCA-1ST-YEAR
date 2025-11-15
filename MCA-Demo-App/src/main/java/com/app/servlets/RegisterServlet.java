package com.app.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.app.database.DatabaseConnection;
import com.app.services.OTPService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("fName_k");
		String lastName = request.getParameter("lName_k");
		String mobileNum = request.getParameter("mob_k");
		String email = request.getParameter("email_k");
		String password = request.getParameter("password_k");
		
		//here we are calling insertUserData fn in order to save user data in the mongo db.
		//if everything is okay the fn says true otherwise the response is false
		boolean dataSaveStatus = DatabaseConnection.insertUserData(firstName, lastName,Long.parseLong(mobileNum) , email, password);
		
		if(dataSaveStatus) {
			//here we are creating a 6 digit OTP.
			int OTP = (int)((Math.random() * 900000) + 100000);
			// here we are calling a fn named sendRegisterOTP which sends an OTP on the user email
			//if everything is okay, the fn says true, otherwise the fn says false;
			// if true --> OTP gaya
			// if false --> OTP nhi gaya
			boolean OTPSentStatus = OTPService.sendRegisterOTP(email, firstName + " " + lastName, OTP);
			
			if(OTPSentStatus) {
				HttpSession session = request.getSession(); // this creates a new session
				session.setAttribute("sentOTP", OTP);
				session.setAttribute("email", email);
				response.sendRedirect("verifyOTP.html");
			}else {
				System.out.println("OTP SENT FAILED");
			}
		}else {
			System.out.println("Data save failed");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

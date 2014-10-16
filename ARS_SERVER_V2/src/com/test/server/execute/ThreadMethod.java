package com.test.server.execute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.test.server.store.UserInputStore;
import com.test.server.ui.ArrivalAirport;
import com.test.server.ui.CheckReservation;
import com.test.server.ui.CheckReview;
import com.test.server.ui.DepartDate;
import com.test.server.ui.DepartTime;
import com.test.server.ui.DepatureAirport;
import com.test.server.ui.PassengerAdult;
import com.test.server.ui.PassengerChild;
import com.test.server.ui.Payment;
import com.test.server.ui.Reservation;
import com.test.server.ui.Review;
import com.test.server.ui.SeatClass;

public class ThreadMethod extends Thread {

	private Socket socket = null;

	public ThreadMethod(Socket socket) {
		this.socket = socket;
	}

	private String statu;

	private String lastStatu;

	private static final String DEPATUREAIRPORT = "depatureairport";

	private static final String RESERVATION = "reservation";

	private static final String ARRIVELAIRPORT = "arrivalairport";

	private static final String DEPARTDATE = "departdate";

	private static final String DEPARTTIME = "departtime";

	private static final String PASSENGER_ADULT = "passenger_adult";

	private static final String PASSENGER_CHILD = "passenger_child";

	private static final String SEATCLASS = "seatclass";

	private static final String PAYMENT = "payment";

	private static final String REVIEW = "review";

	private static final String CHECKREVIEW = "checkreview";

	private static final String CHECKRESERVATION = "checkreservation";

	private String airNo;
	
	//记录用户的输入 
	private UserInputStore clientInputs = new UserInputStore();

	private PrintWriter os = null;
	
	private BufferedReader is = null;
	
	
	@Override
	public void run() {
		if (socket == null) {
			return;
		}
		statu = RESERVATION;
		
		String messageFromClient = "";
		try {
			os = new PrintWriter(socket.getOutputStream());
			is = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			while (true) {
				switch (statu) {
				case RESERVATION: {
					Reservation reservationnew = new Reservation(os, is);
					statu = this.processController(reservationnew.execute());
					break;
				}
				case DEPATUREAIRPORT: {
					DepatureAirport depatureAirport = new DepatureAirport(os,
							is);
					messageFromClient = depatureAirport.execute();
					if ("p".equalsIgnoreCase(messageFromClient)) {
						statu = this.processController(messageFromClient);
						break;
					}
					if ("q".equalsIgnoreCase(messageFromClient)) {
						socket.close();
						break;
					}
					clientInputs.addUserInputCmd(messageFromClient);
					statu = this.processController(messageFromClient);
					break;
				}
				case ARRIVELAIRPORT: {
					ArrivalAirport arrivalAirport = new ArrivalAirport(os,clientInputs, is);
					messageFromClient = arrivalAirport.execute();
					if ("p".equalsIgnoreCase(messageFromClient)) {
						statu = this.processController(messageFromClient);
						clientInputs.removeUserInputLastCmd();
						break;
					}
					if ("q".equalsIgnoreCase(messageFromClient)) {
						socket.close();
						break;
					}
					clientInputs.addUserInputCmd(messageFromClient);
					statu = this.processController(messageFromClient);
					break;
				}
				case DEPARTDATE: {
					DepartDate departDate = new DepartDate(os, is);
					messageFromClient = departDate.execute();
					if ("p".equalsIgnoreCase(messageFromClient)) {
						statu = this.processController(messageFromClient);
						clientInputs.removeUserInputLastCmd();
						break;
					}
					if ("q".equalsIgnoreCase(messageFromClient)) {
						socket.close();
						break;
					}
					clientInputs.addUserInputCmd(messageFromClient);
					statu = this.processController(messageFromClient);
					break;
				}
				case DEPARTTIME: {
					DepartTime departTime = new DepartTime(os, is, clientInputs);
					messageFromClient = departTime.execute();
					if ("p".equalsIgnoreCase(messageFromClient)) {
						statu = this.processController(messageFromClient);
						clientInputs.removeUserInputLastCmd();
						break;
					}
					if ("q".equalsIgnoreCase(messageFromClient)) {
						socket.close();
						break;
					}
					clientInputs.addUserInputCmd(messageFromClient);
					statu = this.processController(messageFromClient);
					break;
				}
				case PASSENGER_ADULT: {
					PassengerAdult passengerAdult = new PassengerAdult(os, is);
					messageFromClient = passengerAdult.execute();
					if ("p".equalsIgnoreCase(messageFromClient)) {
						statu = this.processController(messageFromClient);
						clientInputs.removeUserInputLastCmd();
						break;
					}
					if ("q".equalsIgnoreCase(messageFromClient)) {
						socket.close();
						break;
					}
					clientInputs.addUserInputCmd(messageFromClient);
					statu = this.processController(messageFromClient);
					break;
				}
				case PASSENGER_CHILD: {
					PassengerChild passengerChild = new PassengerChild(os, is,
							clientInputs);
					messageFromClient = passengerChild.execute();
					if ("p".equalsIgnoreCase(messageFromClient)) {
						statu = this.processController(messageFromClient);
						clientInputs.removeUserInputLastCmd();
						break;
					}
					if ("q".equalsIgnoreCase(messageFromClient)) {
						socket.close();
						break;
					}
					clientInputs.addUserInputCmd(messageFromClient);
					statu = this.processController(messageFromClient);
					break;
				}
				case SEATCLASS: {
					SeatClass seatClass = new SeatClass(os, is, clientInputs);
					messageFromClient = seatClass.execute();
					if ("p".equalsIgnoreCase(messageFromClient)) {
						statu = this.processController(messageFromClient);
						clientInputs.removeUserInputLastCmd();
						break;
					}
					if ("q".equalsIgnoreCase(messageFromClient)) {
						socket.close();
						break;
					}
					clientInputs.addUserInputCmd(messageFromClient);
					statu = this.processController(messageFromClient);
					break;
				}
				case PAYMENT: {
					Payment payment = new Payment(os, is, clientInputs);
					messageFromClient = payment.execute();
					if ("p".equalsIgnoreCase(messageFromClient)) {
						statu = this.processController(messageFromClient);
						clientInputs.removeUserInputLastCmd();
						break;
					}
					if ("q".equalsIgnoreCase(messageFromClient)) {
						socket.close();
						break;
					}
					clientInputs.addUserInputCmd(messageFromClient);
					statu = this.processController(messageFromClient);
					break;
				}
				case REVIEW: {
					Review review = new Review(os, is, clientInputs);
					messageFromClient = review.execute();
					statu = this.processController(messageFromClient);
					break;
				}
				case CHECKRESERVATION: {
					CheckReservation checkReservation = new CheckReservation(
							os, is);
					messageFromClient = checkReservation.execute();
					airNo=messageFromClient;
					if ("p".equalsIgnoreCase(messageFromClient)) {
						statu = this.processController(messageFromClient);
						break;
					}
					if ("q".equalsIgnoreCase(messageFromClient)) {
						socket.close();
						break;
					}
					statu = this.processController(messageFromClient);
					break;
				}
				case CHECKREVIEW: {
					CheckReview checkReview = new CheckReview(os,is,airNo);
					messageFromClient = checkReview.execute();
					if ("p".equalsIgnoreCase(messageFromClient)) {
						statu = this.processController(messageFromClient);
						break;
					}
					if ("q".equalsIgnoreCase(messageFromClient)) {
						socket.close();
						break;
					}
					statu = this.processController(messageFromClient);
					break;
				}
				}
			}

		} catch (IOException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			if (os != null) 
			{
				os.close();
			}
			if(is!=null)
			{
				try 
				{
					is.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}

	private String processController(String choice) {
		String nextStatu = "";
		switch (statu) {
		case RESERVATION: {
			if ("1".equals(choice)) {
				nextStatu = DEPATUREAIRPORT;
			}
			if ("2".equals(choice)) {
				lastStatu = RESERVATION;
				nextStatu = CHECKRESERVATION;
			} else if ("q".equalsIgnoreCase(choice)) {
				System.exit(0);
			}
			break;
		}
		case DEPATUREAIRPORT: {
			if ("p".equalsIgnoreCase(choice)) {
				nextStatu = RESERVATION;
				break;
			}
			lastStatu = DEPATUREAIRPORT;
			nextStatu = ARRIVELAIRPORT;
			break;
		}
		case ARRIVELAIRPORT: {
			if ("p".equalsIgnoreCase(choice)) {
				nextStatu = DEPATUREAIRPORT;
				break;
			}
			lastStatu = ARRIVELAIRPORT;
			nextStatu = DEPARTDATE;
			break;
		}
		case DEPARTDATE: {
			if ("p".equalsIgnoreCase(choice)) {
				nextStatu = ARRIVELAIRPORT;
				break;
			}
			lastStatu = DEPARTDATE;
			nextStatu = DEPARTTIME;
			break;
		}
		case DEPARTTIME: {
			if ("p".equalsIgnoreCase(choice)) {
				nextStatu = DEPARTDATE;
				break;
			}
			lastStatu = DEPARTTIME;
			nextStatu = PASSENGER_ADULT;
			break;
		}
		case PASSENGER_ADULT: {
			if ("p".equalsIgnoreCase(choice)) {
				nextStatu = DEPARTTIME;
				break;
			}
			lastStatu = PASSENGER_ADULT;
			nextStatu = PASSENGER_CHILD;
			break;
		}
		case PASSENGER_CHILD: {
			if ("p".equalsIgnoreCase(choice)) {
				nextStatu = PASSENGER_ADULT;
				break;
			}
			lastStatu = PASSENGER_CHILD;
			nextStatu = SEATCLASS;
			break;
		}
		case SEATCLASS: {
			if ("p".equalsIgnoreCase(choice)) {
				nextStatu = PASSENGER_CHILD;
				break;
			}
			lastStatu = SEATCLASS;
			nextStatu = PAYMENT;
			break;
		}
		case PAYMENT: {
			if ("p".equalsIgnoreCase(choice)) {
				nextStatu = SEATCLASS;
				break;
			}
			lastStatu = PAYMENT;
			nextStatu = REVIEW;
			break;
		}
		case REVIEW: {
			if ("p".equalsIgnoreCase(choice)
					&& !CHECKRESERVATION.equals(lastStatu)) {
				lastStatu = REVIEW;
				nextStatu = PAYMENT;
				break;
			}
			if ("p".equalsIgnoreCase(choice)
					&& CHECKRESERVATION.equals(lastStatu)) {
				nextStatu = RESERVATION;
				break;
			}
			lastStatu = REVIEW;
			nextStatu = RESERVATION;
			break;
		}
		case CHECKRESERVATION: {
			if ("p".equalsIgnoreCase(choice)) {
				nextStatu = RESERVATION;
				break;
			}
			lastStatu = CHECKRESERVATION;
			nextStatu = CHECKREVIEW;
			break;
		}
		case CHECKREVIEW: {
			if ("p".equalsIgnoreCase(choice)) {
				nextStatu = CHECKRESERVATION;
				break;
			}
			break;
		}
		}
		return nextStatu;
	}
	
	
}

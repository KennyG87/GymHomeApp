package com.studentslogin.model;

import java.util.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class StudentsJNDIDAO implements StudentsDAO_interface {

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String  
	INSERT = "INSERT INTO STUDENTS(STU_ACC, STU_NO, STU_PSW, STU_ACC_STA, STU_NAME, STU_SEX, STU_ID, STU_MAIL, STU_INTO, STU_PIC, STU_STO) VALUES(?, STUDENTS_NO_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE STUDENTS SET STU_ACC = ?, STU_PSW = ?, STU_NAME = ?, STU_MAIL = ?, STU_INTO= ?, STU_PIC = ?, STU_STO = ? WHERE STU_NO = ?";
	private static final String DELETE = "DELETE FROM STUDENTS WHERE STU_NO = ?";
	private static final String FIND_BY_PK = "SELECT * FROM STUDENTS WHERE STU_NO = ?";
	private static final String GET_ALL = "SELECT * FROM STUDENTS";

		@Override
		public void insert(StudentsVO studentsVO) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(INSERT);

				pstmt.setString(1, studentsVO.getStu_acc());
				pstmt.setString(2, studentsVO.getStu_psw());
				pstmt.setInt(3, studentsVO.getStu_acc_sta());
				pstmt.setString(4, studentsVO.getStu_name());
				pstmt.setInt(5, studentsVO.getStu_sex());
				pstmt.setString(6, studentsVO.getStu_id());
				pstmt.setString(7, studentsVO.getStu_mail());
				pstmt.setString(8, studentsVO.getStu_into());
				pstmt.setBytes(9, studentsVO.getStu_pic());
				pstmt.setDouble(10, studentsVO.getStu_sto());
				pstmt.executeUpdate();
				

				// Handle any driver errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				// Clean up JDBC resources
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}

		}

		@Override
		public void update(StudentsVO studentsVO) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE);

				pstmt.setString(1, studentsVO.getStu_acc());
				pstmt.setString(2, studentsVO.getStu_psw());
				pstmt.setString(3, studentsVO.getStu_name());
				pstmt.setString(4, studentsVO.getStu_mail());
				pstmt.setString(5, studentsVO.getStu_into());
				pstmt.setBytes(6, studentsVO.getStu_pic());
				pstmt.setDouble(7, studentsVO.getStu_sto());
				pstmt.setInt(8, studentsVO.getStu_no());
				pstmt.executeUpdate();

				// Handle any driver errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				// Clean up JDBC resources
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}

		}

		@Override
		public void delete(String stu_no) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(DELETE);

				pstmt.setString(1, stu_no);

				pstmt.executeUpdate();

				// Handle any driver errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				// Clean up JDBC resources
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}

		}

		@Override
		public StudentsVO findByPK(String stu_acc) {
			StudentsVO studentsVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(FIND_BY_PK);

				pstmt.setString(1, stu_acc);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					studentsVO = new StudentsVO();
					studentsVO.setStu_acc(rs.getString("Stu_ACC"));
					studentsVO.setStu_no(rs.getInt("Stu_NO"));
					studentsVO.setStu_psw(rs.getString("Stu_PSW"));
					studentsVO.setStu_acc_sta(rs.getInt("Stu_ACC_STA"));
					studentsVO.setStu_name(rs.getString("Stu_NAME"));
					studentsVO.setStu_sex(rs.getInt("Stu_SEX"));
					studentsVO.setStu_id(rs.getString("Stu_ID"));
					studentsVO.setStu_mail(rs.getString("Stu_MAIL"));
					studentsVO.setStu_into(rs.getString("Stu_INTO"));
					studentsVO.setStu_pic(rs.getBytes("Stu_PIC"));
					studentsVO.setStu_pic(rs.getBytes("Stu_PFT"));
				}

				// Handle any driver errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				// Clean up JDBC resources
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}
			return studentsVO;
		}

		@Override
		public List<StudentsVO> getAll() {
			List<StudentsVO> studentslist = new ArrayList<>();
			StudentsVO studentsVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALL);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					studentsVO = new StudentsVO();
					studentsVO.setStu_acc(rs.getString("Stu_ACC"));
					studentsVO.setStu_no(rs.getInt("Stu_NO"));
					studentsVO.setStu_psw(rs.getString("Stu_PSW"));
					studentsVO.setStu_acc_sta(rs.getInt("Stu_ACC_STA"));
					studentsVO.setStu_name(rs.getString("Stu_NAME"));
					studentsVO.setStu_sex(rs.getInt("Stu_SEX"));
					studentsVO.setStu_id(rs.getString("Stu_ID"));
					studentsVO.setStu_mail(rs.getString("Stu_MAIL"));
					studentsVO.setStu_into(rs.getString("Stu_INTO"));
					studentsVO.setStu_pic(rs.getBytes("Stu_PIC"));
					studentsVO.setStu_pic(rs.getBytes("Stu_PFT"));
				}

				// Handle any driver errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				// Clean up JDBC resources
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}
			return studentslist;
		}
//		//使用byte[]方式
		public static byte[] getPictureByteArray(String path) throws IOException {
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[8192];
			int i;
			while ((i = fis.read(buffer)) != -1) {
				baos.write(buffer, 0, i);
			}
			baos.close();
			fis.close();

			return baos.toByteArray();
		}
}
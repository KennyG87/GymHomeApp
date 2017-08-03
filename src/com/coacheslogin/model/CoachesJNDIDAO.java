package com.coacheslogin.model;

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

public class CoachesJNDIDAO implements CoachesDAO_interface {

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

	private static final String INSERT = "INSERT INTO COACHES(COA_ACC, COA_NO, COA_PSW, COA_STA, COA_NAME, COA_SEX, COA_ID, COA_MAIL, COA_INTO, COA_PIC, COA_PFT)"
			+ "VALUES(?, COACHES_NO_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE COACHES SET COA_ACC = ?, COA_PSW = ?, COA_NAME = ?, COA_MAIL = ?, COA_INTO= ?, COA_PIC = ?, COA_PFT = ? WHERE COA_NO = ?";
	private static final String DELETE = "DELETE FROM COACHES WHERE COA_NO = ?";
	private static final String FIND_BY_PK = "SELECT * FROM COACHES WHERE COA_ACC = ?";
	private static final String GET_ALL = "SELECT * FROM COACHES";

		@Override
		public void insert(CoachesVO coachesVO) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(INSERT);

				pstmt.setString(1, coachesVO.getCoa_acc());
				pstmt.setString(2, coachesVO.getCoa_psw());
				pstmt.setInt(3, coachesVO.getCoa_sta());
				pstmt.setString(4, coachesVO.getCoa_name());
				pstmt.setInt(5, coachesVO.getCoa_sex());
				pstmt.setString(6, coachesVO.getCoa_id());
				pstmt.setString(7, coachesVO.getCoa_mail());
				pstmt.setString(8, coachesVO.getCoa_into());
				pstmt.setBytes(9,coachesVO.getCoa_pic());
				pstmt.setDouble(10, coachesVO.getCoa_pft());
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
		public void update(CoachesVO coachesVO) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE);

				pstmt.setString(1, coachesVO.getCoa_acc());
				pstmt.setString(2, coachesVO.getCoa_psw());
				pstmt.setString(3, coachesVO.getCoa_name());
				pstmt.setString(4, coachesVO.getCoa_mail());
				pstmt.setString(5, coachesVO.getCoa_into());
				pstmt.setBytes(6, coachesVO.getCoa_pic());
				pstmt.setDouble(7, coachesVO.getCoa_pft());
				pstmt.setInt(8, coachesVO.getCoa_no());
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
		public void delete(String coa_no) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(DELETE);

				pstmt.setString(1, coa_no);

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
		public CoachesVO findByPK(String coa_acc) {
			CoachesVO coachesVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(FIND_BY_PK);

				pstmt.setString(1, coa_acc);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					coachesVO = new CoachesVO();
					coachesVO.setCoa_acc(rs.getString("COA_ACC"));
					coachesVO.setCoa_no(rs.getInt("COA_NO"));
					coachesVO.setCoa_psw(rs.getString("COA_PSW"));
					coachesVO.setCoa_sta(rs.getInt("COA_STA"));
					coachesVO.setCoa_name(rs.getString("COA_NAME"));
					coachesVO.setCoa_sex(rs.getInt("COA_SEX"));
					coachesVO.setCoa_id(rs.getString("COA_ID"));
					coachesVO.setCoa_mail(rs.getString("COA_MAIL"));
					coachesVO.setCoa_into(rs.getString("COA_INTO"));
					coachesVO.setCoa_pic(rs.getBytes("COA_PIC"));
					coachesVO.setCoa_pic(rs.getBytes("COA_PFT"));
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
			return coachesVO;
		}

		@Override
		public List<CoachesVO> getAll() {
			List<CoachesVO> coacheslist = new ArrayList<>();
			CoachesVO coachesVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALL);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					coachesVO = new CoachesVO();
					coachesVO.setCoa_acc(rs.getString("COA_ACC"));
					coachesVO.setCoa_no(rs.getInt("COA_NO"));
					coachesVO.setCoa_psw(rs.getString("COA_PSW"));
					coachesVO.setCoa_sta(rs.getInt("COA_STA"));
					coachesVO.setCoa_name(rs.getString("COA_NAME"));
					coachesVO.setCoa_sex(rs.getInt("COA_SEX"));
					coachesVO.setCoa_id(rs.getString("COA_ID"));
					coachesVO.setCoa_mail(rs.getString("COA_MAIL"));
					coachesVO.setCoa_into(rs.getString("COA_INTO"));
					coachesVO.setCoa_pic(rs.getBytes("COA_PIC"));
					coachesVO.setCoa_pic(rs.getBytes("COA_PFT"));
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
			return coacheslist;
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
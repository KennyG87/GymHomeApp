package com.members.model;

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

public class MembersJNDIDAO implements MembersDAO_interface {

	// �??��?�用程�?�中,??��?��??��?��?�庫 ,?��?���??�DataSource?��?��
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
	INSERT = "INSERT INTO MEMBERS(MEM_NO, MEM_ACC, MEM_RANK, MEM_NICKNAME) VALUES(MEMBERS_NO_SEQ.NEXTVAL, ?, ?, ?)";
	private static final String UPDATE = "UPDATE MEMBERS SET MEM_ACC = ?, MEM_RANK = ?, MEM_NICKNAME = ? WHERE MEM_NO = ?";
	private static final String DELETE = "DELETE FROM MEMBERS WHERE MEM_NO = ?";
	private static final String FIND_BY_PK = "SELECT * FROM MEMBERS WHERE MEM_NO = ?";
	private static final String GET_ALL = "SELECT * FROM MEMBERS";

		@Override
		public void insert(MembersVO membersVO) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(INSERT);

				pstmt.setString(1, membersVO.getMem_acc());
				pstmt.setString(2, membersVO.getMem_rank());
				pstmt.setString(3, membersVO.getMem_nickname());
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
		public void update(MembersVO membersVO) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE);

				pstmt.setString(1, membersVO.getMem_acc());
				pstmt.setString(2, membersVO.getMem_rank());
				pstmt.setString(3, membersVO.getMem_nickname());
				pstmt.setInt(4, membersVO.getMem_no());
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
		public void delete(String mem_no) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(DELETE);

				pstmt.setString(1, mem_no);

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
		public MembersVO findByPK(String mem_acc) {
			MembersVO membersVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(FIND_BY_PK);

				pstmt.setString(1, mem_acc);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					membersVO = new MembersVO();
					membersVO.setMem_no(rs.getInt("MEM_NO"));;
					membersVO.setMem_acc(rs.getString("MEM_ACC"));
					membersVO.setMem_rank(rs.getString("MEM_RANK"));
					membersVO.setMem_nickname(rs.getString("MEM_NICKNAME"));				}

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
			return membersVO;
		}

		@Override
		public List<MembersVO> getAll() {
			List<MembersVO> memberslist = new ArrayList<>();
			MembersVO membersVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALL);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					membersVO = new MembersVO();
					membersVO.setMem_no(rs.getInt("MEM_NO"));;
					membersVO.setMem_acc(rs.getString("MEM_ACC"));
					membersVO.setMem_rank(rs.getString("MEM_RANK"));
					membersVO.setMem_nickname(rs.getString("MEM_NICKNAME"));
					memberslist.add(membersVO);				}

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
			return memberslist;
		}


}
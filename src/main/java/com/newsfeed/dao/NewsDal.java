package com.newsfeed.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.newsfeed.decorators.HeadlineDecorator;
import com.newsfeed.entities.Headline;
import com.newsfeed.entities.User;

public class NewsDal {

	Connection con = null;

	public NewsDal() {
		con = DatabaseSingleton.getDBConnection();
	}

	public User getUser(String username, String pwd) throws SQLException {

		String SelectUsersByPrimaryKeyStatement = "SELECT user_id, user.name, user.username,user.password,user.role,user.address,user.gender,user.dept FROM newsdb.user"
				+ " where user.username=? and user.password = ?;";
		PreparedStatement ps = null;
		ResultSet rSet = null;
		try {
			// con = DatabaseSingleton.getDBConnection();
			ps = con.prepareStatement(SelectUsersByPrimaryKeyStatement);
			ps.setString(1, username);
			ps.setString(2, pwd);
			rSet = ps.executeQuery();
			if (rSet.next()) {
				User u = new User();
				u.setUserId(rSet.getInt("user_id"));
				u.setName(rSet.getString("name"));
				u.setUserName(rSet.getString("username"));
				u.setPassword(rSet.getString("password"));
				u.setRole(rSet.getInt("role"));
				u.setAddress(rSet.getString("address"));
				u.setGender(rSet.getInt("gender"));
				u.setDept(rSet.getInt("dept"));
				return u;
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (rSet != null)
				rSet.close();
			if (ps != null)
				ps.close();
			/* con.close(); */
		}
	}

	public int insertUser(User u, int roleid) throws SQLException {

		String SelectUsersByPrimaryKeyStatement = "INSERT INTO newsdb.user (name, username, password, role, address, gender,dept) VALUES (?,?,?,?,?,?,?);";
		PreparedStatement ps = null;
		ResultSet rSet = null;
		int result = -1;
		try {
			// con = DatabaseSingleton.getDBConnection();
			ps = con.prepareStatement(SelectUsersByPrimaryKeyStatement);
			ps.setString(1, u.getName());
			ps.setString(2, u.getUserName());
			ps.setString(3, u.getPassword());
			ps.setInt(4, roleid);
			ps.setString(5, u.getAddress());
			ps.setInt(6, u.getGender());
			ps.setInt(7, u.getDept());

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				result = rs.getInt(1);
			}
			// return rSet;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (rSet != null)
				rSet.close();
			if (ps != null)
				ps.close();
			/* con.close(); */
		}
		return result;
	}

	public ArrayList<User> getAllEditors() throws SQLException {

		ArrayList<User> editors = new ArrayList<User>();
		String selectEditors = "SELECT user_id, user.name, user.username,user.password,user.role,user.address,user.gender,user.dept FROM newsdb.user"
				+ " where user.role = 2;";
		PreparedStatement ps = null;
		ResultSet rSet = null;
		try {
			// con = DatabaseSingleton.getDBConnection();
			ps = con.prepareStatement(selectEditors);
			rSet = ps.executeQuery();
			while (rSet.next()) {
				User u = new User();
				u.setUserId(rSet.getInt("user_id"));
				u.setName(rSet.getString("name"));
				u.setUserName(rSet.getString("username"));
				u.setPassword(rSet.getString("password"));
				u.setRole(rSet.getInt("role"));
				u.setAddress(rSet.getString("address"));
				u.setGender(rSet.getInt("gender"));
				u.setDept(rSet.getInt("dept"));

				editors.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (rSet != null)
				rSet.close();
			if (ps != null)
				ps.close();
			/* con.close(); */
		}
		return editors;
	}

	public int deleteUser(int uid) throws SQLException {
		String delStatement = "DELETE FROM newsdb.user WHERE user_id=?;";

		PreparedStatement ps = null;
		int result = -1;
		try {
			con = DatabaseSingleton.getDBConnection();
			ps = con.prepareStatement(delStatement);
			ps.setInt(1, uid);
			result = ps.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (ps != null)
				ps.close();
			// con.close();
		}
	}

	public ArrayList<Headline> getNewsFeeds() throws SQLException {
		ArrayList<Headline> headlines = new ArrayList<Headline>();
		String selectFeeds = "SELECT newsfeed.feedId, newsfeed.headline, newsfeed.deptId FROM newsdb.newsfeed;";

		PreparedStatement ps = null;
		ResultSet rSet = null;
		try {
			// con = DatabaseSingleton.getDBConnection();
			ps = con.prepareStatement(selectFeeds);
			rSet = ps.executeQuery();
			while (rSet.next()) {
				Headline h = new Headline();
				h.setHeadlineId(rSet.getInt("feedId"));
				h.setDescription(rSet.getString("headline"));
				h.setDeptId(rSet.getInt("deptId"));

				headlines.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (rSet != null)
				rSet.close();
			if (ps != null)
				ps.close();
			/* con.close(); */
		}
		return headlines;
	}

	public ArrayList<Headline> getInternetFeeds() throws SQLException {
		ArrayList<Headline> headlines = new ArrayList<Headline>();
		String selectFeeds = "SELECT internetfeed.feedId, internetfeed.headline, internetfeed.deptId FROM newsdb.internetfeed;";

		PreparedStatement ps = null;
		ResultSet rSet = null;
		try {
			// con = DatabaseSingleton.getDBConnection();
			ps = con.prepareStatement(selectFeeds);
			rSet = ps.executeQuery();
			while (rSet.next()) {
				Headline h = new Headline();
				h.setHeadlineId(rSet.getInt("feedId"));
				h.setDescription(rSet.getString("headline"));
				h.setDeptId(rSet.getInt("deptId"));

				headlines.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (rSet != null)
				rSet.close();
			if (ps != null)
				ps.close();
			/* con.close(); */
		}
		return headlines;
	}

	public ArrayList<Headline> getTwitterFeeds() throws SQLException {
		ArrayList<Headline> headlines = new ArrayList<Headline>();
		String selectFeeds = "SELECT twitterfeed.feedId, twitterfeed.headline, twitterfeed.deptId FROM newsdb.twitterfeed;";

		PreparedStatement ps = null;
		ResultSet rSet = null;
		try {
			// con = DatabaseSingleton.getDBConnection();
			ps = con.prepareStatement(selectFeeds);
			rSet = ps.executeQuery();
			while (rSet.next()) {
				Headline h = new Headline();
				h.setHeadlineId(rSet.getInt("feedId"));
				h.setDescription(rSet.getString("headline"));
				h.setDeptId(rSet.getInt("deptId"));

				headlines.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (rSet != null)
				rSet.close();
			if (ps != null)
				ps.close();
			/* con.close(); */
		}
		return headlines;
	}

	public int insertFeed(Headline headline) throws SQLException {

		String feedInsert = "INSERT INTO newsdb.feed () VALUES ();";
		PreparedStatement ps = null;
		ResultSet rSet = null;
		int result = -1;
		try {
			// con = DatabaseSingleton.getDBConnection();
			ps = con.prepareStatement(feedInsert);
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				insertInternetFeed(headline, key);
				insertNewsFeed(headline, key);
				insertTwitterFeed(headline, key);
				}
			// return rSet;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (rSet != null)
				rSet.close();
			if (ps != null)
				ps.close();
			/* con.close(); */
		}
		return result;

	}

	public boolean insertInternetFeed(Headline headline, int key) throws SQLException {
		String insertIFeed = "INSERT INTO newsdb.internetfeed (feedId,headline,deptId) VALUES (?,?,?);";
		PreparedStatement ps = null;
		ResultSet rSet = null;
		boolean result = false;
		try {
			// con = DatabaseSingleton.getDBConnection();
			ps = con.prepareStatement(insertIFeed);
			ps.setInt(1, key);
			ps.setString(2, headline.getDescription());
			ps.setInt(3, headline.getDeptId());
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				result = true;
			}
			// return rSet;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (rSet != null)
				rSet.close();
			if (ps != null)
				ps.close();
			/* con.close(); */
		}
		return result;

		
	}

	public boolean insertNewsFeed(Headline headline, int key) throws SQLException {
		String insertNFeed = "INSERT INTO newsdb.newsfeed (feedId,headline,deptId) VALUES (?,?,?);";
		PreparedStatement ps = null;
		ResultSet rSet = null;
		boolean result = false;
		try {
			// con = DatabaseSingleton.getDBConnection();
			ps = con.prepareStatement(insertNFeed);
			ps.setInt(1, key);
			ps.setString(2, headline.getDescription());
			ps.setInt(3, headline.getDeptId());
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				result = true;
			}
			// return rSet;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (rSet != null)
				rSet.close();
			if (ps != null)
				ps.close();
			/* con.close(); */
		}
		return result;

	}

	public boolean insertTwitterFeed(Headline headline, int key) throws SQLException {
		String insertTFeed = "INSERT INTO newsdb.twitterfeed (feedId,headline,deptId) VALUES (?,?,?);";
		PreparedStatement ps = null;
		ResultSet rSet = null;
		boolean result = false;
		try {
			// con = DatabaseSingleton.getDBConnection();
			ps = con.prepareStatement(insertTFeed);
			ps.setInt(1, key);
			ps.setString(2, headline.getDescription());
			ps.setInt(3, headline.getDeptId());
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				result = true;
			}
			// return rSet;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (rSet != null)
				rSet.close();
			if (ps != null)
				ps.close();
			/* con.close(); */
		}
		return result;

	}
	
	public ArrayList<Headline> getNewsFeedsForEditor(int department) throws SQLException {
		ArrayList<Headline> headlines = new ArrayList<Headline>();
		String selectFeeds = "SELECT newsfeed.feedId, newsfeed.headline, newsfeed.deptId FROM newsdb.newsfeed "
								+ "where deptId = ?;";

		PreparedStatement ps = null;
		ResultSet rSet = null;
		try {
			// con = DatabaseSingleton.getDBConnection();
			ps = con.prepareStatement(selectFeeds);
			ps.setInt(1, department);
			rSet = ps.executeQuery();
			while (rSet.next()) {
				Headline h = new Headline();
				h.setHeadlineId(rSet.getInt("feedId"));
				h.setDescription(rSet.getString("headline"));
				h.setDeptId(rSet.getInt("deptId"));

				headlines.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (rSet != null)
				rSet.close();
			if (ps != null)
				ps.close();
			/* con.close(); */
		}
		return headlines;
	}

	public int deleteHeadline(int fid) throws SQLException {
		String delStatement = "DELETE FROM newsdb.feed WHERE feedId=?;";

		PreparedStatement ps = null;
		int result = -1;
		try {
			con = DatabaseSingleton.getDBConnection();
			ps = con.prepareStatement(delStatement);
			ps.setInt(1, fid);
			result = ps.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (ps != null)
				ps.close();
			// con.close();
		}
	}

}

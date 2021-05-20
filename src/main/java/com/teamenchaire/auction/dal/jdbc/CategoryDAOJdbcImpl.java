package com.teamenchaire.auction.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.teamenchaire.auction.BusinessException;
import com.teamenchaire.auction.bo.Category;
import com.teamenchaire.auction.dal.CategoryDAO;
import com.teamenchaire.auction.dal.DALErrorCode;

/**
 * A {@code class} which implements CRUD methods for categories in the database
 * using the JDBC driver.
 * 
 * @author Marin Taverniers
 */
public class CategoryDAOJdbcImpl implements CategoryDAO {
    private static final String SQL_SELECT_ALL = "SELECT * FROM categories";

    /**
     * Constructs a {@code CategoryDAOJdbcImpl}.
     */
    public CategoryDAOJdbcImpl() {
        // Default constructor
    }

    @Override
    public void insert(final Category category) throws BusinessException {
        throw new BusinessException(DALErrorCode.SQL_INSERT);
    }

    @Override
    public void update(final Category category) throws BusinessException {
        throw new BusinessException(DALErrorCode.SQL_UPDATE);
    }

    @Override
    public void delete(final Category category) throws BusinessException {
        throw new BusinessException(DALErrorCode.SQL_DELETE);
    }

    @Override
    public List<Category> selectAll() throws BusinessException {
        final List<Category> categories = new ArrayList<>();
        try (Connection connection = JdbcConnectionProvider.getConnection();
                Statement statement = connection.createStatement()) {
            final ResultSet result = statement.executeQuery(SQL_SELECT_ALL);
            while (result.next()) {
                categories.add(buildCategory(result));
            }
        } catch (final SQLException e) {
            throw new BusinessException(DALErrorCode.SQL_SELECT, e);
        }
        return categories;
    }

    @Override
    public Category selectById(final Integer id) throws BusinessException {
        throw new BusinessException(DALErrorCode.SQL_SELECT);
    }

    private static Category buildCategory(final ResultSet result) throws SQLException {
        return new Category(result.getInt("id_category"), result.getString("category_name"));
    }
}
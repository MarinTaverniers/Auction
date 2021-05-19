package com.teamenchaire.auction.bll;

import java.util.List;

import com.teamenchaire.auction.BusinessException;
import com.teamenchaire.auction.bo.Category;
import com.teamenchaire.auction.dal.CategoryDAO;
import com.teamenchaire.auction.dal.DAOFactory;

/**
 * A {@code class} which controls categories using a data access object.
 */
public final class CategoryManager {
    private final CategoryDAO categoryDAO;

    /**
     * Constructs a {@code CategoryManager} using a data access object.
     */
    public CategoryManager() {
        this.categoryDAO = DAOFactory.getCategoryDAO();
    }

    public List<Category> getCategories() throws BusinessException {
        return categoryDAO.selectAll();
    }
}
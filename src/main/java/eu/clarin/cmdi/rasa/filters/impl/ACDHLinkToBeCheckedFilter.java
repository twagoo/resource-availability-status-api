/*
 * Copyright (C) 2019 CLARIN
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package eu.clarin.cmdi.rasa.filters.impl;

import eu.clarin.cmdi.rasa.filters.LinkToBeCheckedFilter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ACDHLinkToBeCheckedFilter implements LinkToBeCheckedFilter {

    private String collection;

    public ACDHLinkToBeCheckedFilter(String collection) {
        this.collection = collection;
    }

    @Override
    public String getCollection() {
        return this.collection;
    }

    @Override
    public PreparedStatement getStatement(Connection con) throws SQLException {
        //if it comes here, then it means there is a collection to be filtered
        String query = "SELECT * FROM urls WHERE collection=?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, collection);

        return statement;
    }
}

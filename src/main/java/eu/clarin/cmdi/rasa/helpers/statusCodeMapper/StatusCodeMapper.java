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

package eu.clarin.cmdi.rasa.helpers.statusCodeMapper;

import java.util.*;

/**
 * Static class to map categories to status codes
 * IMPORTANT: The mapping will soon be deprecated and categories will be directly persisted in the database
 */
public final class StatusCodeMapper {
    //this map is used by curation module
    private static Map<Integer, Category> map;

    //broken can be derived from not in ok and not in undetermined
    private static final List<Integer> undetermined;
    private static final List<Integer> ok;

    static {
        map = new HashMap<>();
        map.put(401, Category.Undetermined);
        map.put(405, Category.Undetermined);
        map.put(429, Category.Undetermined);
        undetermined = Arrays.asList(401, 405, 429);

        map.put(200, Category.Ok);
        ok = Collections.singletonList(200);

    }

    /**
     * Get category from the status code
     * @param status status code requested
     * @deprecated soon to be
     * @return category of the given status code
     */
    public static Category get(int status) {
        Category category = map.get(status);
        return category == null ? Category.Broken : category;
    }

    /**
     * Get status code integers for ok category
     * @deprecated soon to be
     * @return list of status codes
     */
    public static List<Integer> getOkStatuses() {
        return new ArrayList<>(ok);
    }

    /**
     * Get status code integers for undetermined category
     * @deprecated soon to be
     * @return list of status codes
     */
    public static List<Integer> getUndeterminedStatuses() {
        return new ArrayList<>(undetermined);
    }
}

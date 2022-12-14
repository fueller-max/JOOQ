/*
 * This file is generated by jOOQ.
 */
package model.enums;


import org.jooq.Catalog;
import org.jooq.EnumType;
import org.jooq.Schema;


/**
 *  :  /  /  / 
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public enum CoursesType implements EnumType {

    DESIGN("DESIGN"),

    PROGRAMMING("PROGRAMMING"),

    MARKETING("MARKETING"),

    MANAGEMENT("MANAGEMENT"),

    BUSINESS("BUSINESS");

    private final String literal;

    private CoursesType(String literal) {
        this.literal = literal;
    }

    @Override
    public Catalog getCatalog() {
        return null;
    }

    @Override
    public Schema getSchema() {
        return null;
    }

    @Override
    public String getName() {
        return "courses_type";
    }

    @Override
    public String getLiteral() {
        return literal;
    }
}

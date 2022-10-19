/*
 * This file is generated by jOOQ.
 */
package model.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import model.Keys;
import model.Skillbox;
import model.tables.records.StudentsRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.UInteger;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Students extends TableImpl<StudentsRecord> {

    private static final long serialVersionUID = 1346675133;

    /**
     * The reference instance of <code>skillbox.students</code>
     */
    public static final Students STUDENTS = new Students();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StudentsRecord> getRecordType() {
        return StudentsRecord.class;
    }

    /**
     * The column <code>skillbox.students.id</code>.
     */
    public final TableField<StudentsRecord, UInteger> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>skillbox.students.name</code>.
     */
    public final TableField<StudentsRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, " ");

    /**
     * The column <code>skillbox.students.age</code>.
     */
    public final TableField<StudentsRecord, UInteger> AGE = createField(DSL.name("age"), org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, " ");

    /**
     * The column <code>skillbox.students.registration_date</code>.
     */
    public final TableField<StudentsRecord, LocalDateTime> REGISTRATION_DATE = createField(DSL.name("registration_date"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, " ");

    /**
     * Create a <code>skillbox.students</code> table reference
     */
    public Students() {
        this(DSL.name("students"), null);
    }

    /**
     * Create an aliased <code>skillbox.students</code> table reference
     */
    public Students(String alias) {
        this(DSL.name(alias), STUDENTS);
    }

    /**
     * Create an aliased <code>skillbox.students</code> table reference
     */
    public Students(Name alias) {
        this(alias, STUDENTS);
    }

    private Students(Name alias, Table<StudentsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Students(Name alias, Table<StudentsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Students(Table<O> child, ForeignKey<O, StudentsRecord> key) {
        super(child, key, STUDENTS);
    }

    @Override
    public Schema getSchema() {
        return Skillbox.SKILLBOX;
    }

    @Override
    public Identity<StudentsRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_STUDENTS;
    }

    @Override
    public UniqueKey<StudentsRecord> getPrimaryKey() {
        return Keys.KEY_STUDENTS_PRIMARY;
    }

    @Override
    public List<UniqueKey<StudentsRecord>> getKeys() {
        return Arrays.<UniqueKey<StudentsRecord>>asList(Keys.KEY_STUDENTS_PRIMARY);
    }

    @Override
    public Students as(String alias) {
        return new Students(DSL.name(alias), this);
    }

    @Override
    public Students as(Name alias) {
        return new Students(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Students rename(String name) {
        return new Students(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Students rename(Name name) {
        return new Students(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<UInteger, String, UInteger, LocalDateTime> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}

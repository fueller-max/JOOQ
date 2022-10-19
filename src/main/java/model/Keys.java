/*
 * This file is generated by jOOQ.
 */
package model;


import model.tables.Courses;
import model.tables.PurchaselistBk;
import model.tables.Students;
import model.tables.Subscriptions;
import model.tables.Teachers;
import model.tables.records.CoursesRecord;
import model.tables.records.PurchaselistBkRecord;
import model.tables.records.StudentsRecord;
import model.tables.records.SubscriptionsRecord;
import model.tables.records.TeachersRecord;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;
import org.jooq.types.UInteger;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>skillbox</code> schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<CoursesRecord, UInteger> IDENTITY_COURSES = Identities0.IDENTITY_COURSES;
    public static final Identity<PurchaselistBkRecord, Integer> IDENTITY_PURCHASELIST_BK = Identities0.IDENTITY_PURCHASELIST_BK;
    public static final Identity<StudentsRecord, UInteger> IDENTITY_STUDENTS = Identities0.IDENTITY_STUDENTS;
    public static final Identity<TeachersRecord, UInteger> IDENTITY_TEACHERS = Identities0.IDENTITY_TEACHERS;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CoursesRecord> KEY_COURSES_PRIMARY = UniqueKeys0.KEY_COURSES_PRIMARY;
    public static final UniqueKey<PurchaselistBkRecord> KEY_PURCHASELIST_BK_PRIMARY = UniqueKeys0.KEY_PURCHASELIST_BK_PRIMARY;
    public static final UniqueKey<StudentsRecord> KEY_STUDENTS_PRIMARY = UniqueKeys0.KEY_STUDENTS_PRIMARY;
    public static final UniqueKey<SubscriptionsRecord> KEY_SUBSCRIPTIONS_UNQ = UniqueKeys0.KEY_SUBSCRIPTIONS_UNQ;
    public static final UniqueKey<TeachersRecord> KEY_TEACHERS_PRIMARY = UniqueKeys0.KEY_TEACHERS_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<CoursesRecord, TeachersRecord> TEACHER = ForeignKeys0.TEACHER;
    public static final ForeignKey<SubscriptionsRecord, StudentsRecord> STUDENT = ForeignKeys0.STUDENT;
    public static final ForeignKey<SubscriptionsRecord, CoursesRecord> COURSE = ForeignKeys0.COURSE;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<CoursesRecord, UInteger> IDENTITY_COURSES = Internal.createIdentity(Courses.COURSES, Courses.COURSES.ID);
        public static Identity<PurchaselistBkRecord, Integer> IDENTITY_PURCHASELIST_BK = Internal.createIdentity(PurchaselistBk.PURCHASELIST_BK, PurchaselistBk.PURCHASELIST_BK.ID);
        public static Identity<StudentsRecord, UInteger> IDENTITY_STUDENTS = Internal.createIdentity(Students.STUDENTS, Students.STUDENTS.ID);
        public static Identity<TeachersRecord, UInteger> IDENTITY_TEACHERS = Internal.createIdentity(Teachers.TEACHERS, Teachers.TEACHERS.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<CoursesRecord> KEY_COURSES_PRIMARY = Internal.createUniqueKey(Courses.COURSES, "KEY_courses_PRIMARY", new TableField[] { Courses.COURSES.ID }, true);
        public static final UniqueKey<PurchaselistBkRecord> KEY_PURCHASELIST_BK_PRIMARY = Internal.createUniqueKey(PurchaselistBk.PURCHASELIST_BK, "KEY_purchaselist_bk_PRIMARY", new TableField[] { PurchaselistBk.PURCHASELIST_BK.ID }, true);
        public static final UniqueKey<StudentsRecord> KEY_STUDENTS_PRIMARY = Internal.createUniqueKey(Students.STUDENTS, "KEY_students_PRIMARY", new TableField[] { Students.STUDENTS.ID }, true);
        public static final UniqueKey<SubscriptionsRecord> KEY_SUBSCRIPTIONS_UNQ = Internal.createUniqueKey(Subscriptions.SUBSCRIPTIONS, "KEY_subscriptions_unq", new TableField[] { Subscriptions.SUBSCRIPTIONS.STUDENT_ID, Subscriptions.SUBSCRIPTIONS.COURSE_ID }, true);
        public static final UniqueKey<TeachersRecord> KEY_TEACHERS_PRIMARY = Internal.createUniqueKey(Teachers.TEACHERS, "KEY_teachers_PRIMARY", new TableField[] { Teachers.TEACHERS.ID }, true);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<CoursesRecord, TeachersRecord> TEACHER = Internal.createForeignKey(Keys.KEY_TEACHERS_PRIMARY, Courses.COURSES, "teacher", new TableField[] { Courses.COURSES.TEACHER_ID }, true);
        public static final ForeignKey<SubscriptionsRecord, StudentsRecord> STUDENT = Internal.createForeignKey(Keys.KEY_STUDENTS_PRIMARY, Subscriptions.SUBSCRIPTIONS, "student", new TableField[] { Subscriptions.SUBSCRIPTIONS.STUDENT_ID }, true);
        public static final ForeignKey<SubscriptionsRecord, CoursesRecord> COURSE = Internal.createForeignKey(Keys.KEY_COURSES_PRIMARY, Subscriptions.SUBSCRIPTIONS, "course", new TableField[] { Subscriptions.SUBSCRIPTIONS.COURSE_ID }, true);
    }
}
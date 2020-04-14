Database Rider H2 issue demo
============================

Demo project to illustrate an issue https://github.com/database-rider/database-rider/issues/97

# The problem

Test fails with `org.dbunit.dataset.NoSuchTableException: The table 'book' does not exist in schema 'PUBLIC'`
when attempting to set up the database via @DataSet

## Details

* issue appears only when reading datasets from `xml` files;
* `yaml` files work fine;
* issue is not reproducible when table names are in upper-case in `xml` format;

The `dbunit.yaml` file does not affect anything.
* `caseSensitiveTableNames` does not fix uppercase/lowercase issue;
* `schema` can be commented out. Passing tests are still passing, so the issue is not with the schema.
 

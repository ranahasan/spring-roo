package org.springframework.roo.addon.dbre;

import java.io.File;
import java.util.Set;

import org.springframework.roo.addon.dbre.model.Schema;
import org.springframework.roo.model.JavaPackage;

/**
 * Interface to commands available in {@link DbreOperationsImpl}.
 * 
 * @author Alan Stewart
 * @since 1.1
 */
public interface DbreOperations {

	boolean isDbreAvailable();

	/**
	 * Displays the metadata for the indicated schema on the screen, or writes it to
	 * the given file if a filename is specified.
	 * 
	 * @param schema the schema to introspect (required)
	 * @param file to write to (can be null, in which case the output will appear on-screen)
	 */
	void displayDatabaseMetadata(Schema schema, File file);

	/**
	 * Introspects the schema and causes the related entities on disk to be created, updated
	 * and deleted.
	 * 
	 * @param schema the schema to reverse engineer (required)
	 * @param destinationPackage the package in which all entities will be stored (if not
	 * given, the project's top level package)
	 * @param excludeTables the set of tables to exclude from reverse engineering.
	 */
	void reverseEngineerDatabase(Schema schema, JavaPackage destinationPackage, Set<String> excludeTables);
}
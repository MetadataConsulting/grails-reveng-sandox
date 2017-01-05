package reveng.ipswitch

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class LocationsLinktableRegulatedActivityContacts implements Serializable {

	String locationId
	String regulatedActivityCode
	String personTitle
	String personGivenName
	String personFamilyName
	String personRoles
	Date apiCallDate
	String uniqueColumn
	Date importDate
	Date createdDate

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append locationId
		builder.append regulatedActivityCode
		builder.append personTitle
		builder.append personGivenName
		builder.append personFamilyName
		builder.append personRoles
		builder.append apiCallDate
		builder.append uniqueColumn
		builder.append importDate
		builder.append createdDate
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append locationId, other.locationId
		builder.append regulatedActivityCode, other.regulatedActivityCode
		builder.append personTitle, other.personTitle
		builder.append personGivenName, other.personGivenName
		builder.append personFamilyName, other.personFamilyName
		builder.append personRoles, other.personRoles
		builder.append apiCallDate, other.apiCallDate
		builder.append uniqueColumn, other.uniqueColumn
		builder.append importDate, other.importDate
		builder.append createdDate, other.createdDate
		builder.isEquals()
	}

	static mapping = {
		id composite: ["locationId", "regulatedActivityCode", "personTitle", "personGivenName", "personFamilyName", "personRoles", "apiCallDate", "uniqueColumn", "importDate", "createdDate"]
        locationId column: 'locationId'
        regulatedActivityCode column: 'regulatedActivityCode'
        personTitle column: 'personTitle'
        personGivenName column: 'personGivenName'
        personFamilyName column: 'personFamilyName'
        personRoles column: 'personRoles'
		version false
	}

	static constraints = {
		locationId maxSize: 15
		regulatedActivityCode maxSize: 50
		personTitle nullable: true, maxSize: 20
		personGivenName nullable: true, maxSize: 100
		personFamilyName nullable: true, maxSize: 100
		personRoles nullable: true
		uniqueColumn maxSize: 545
		// createdDate unique: ["uniqueColumn"]
	}
}

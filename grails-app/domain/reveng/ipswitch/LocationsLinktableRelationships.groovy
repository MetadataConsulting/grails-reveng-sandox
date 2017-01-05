package reveng.ipswitch

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class LocationsLinktableRelationships implements Serializable {

	String locationId
	String relatedLocationId
	String relatedLocationName
	String type
	String reason
	Date apiCallDate
	String uniqueColumn
	Date importDate
	Date createdDate

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append locationId
		builder.append relatedLocationId
		builder.append relatedLocationName
		builder.append type
		builder.append reason
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
		builder.append relatedLocationId, other.relatedLocationId
		builder.append relatedLocationName, other.relatedLocationName
		builder.append type, other.type
		builder.append reason, other.reason
		builder.append apiCallDate, other.apiCallDate
		builder.append uniqueColumn, other.uniqueColumn
		builder.append importDate, other.importDate
		builder.append createdDate, other.createdDate
		builder.isEquals()
	}

	static mapping = {
		id composite: ["locationId", "relatedLocationId", "relatedLocationName", "type", "reason", "apiCallDate", "uniqueColumn", "importDate", "createdDate"]
        locationId column: 'locationId'
        relatedLocationId column: 'relatedLocationId'
        relatedLocationName column: 'relatedLocationName'
		version false
	}

	static constraints = {
		locationId maxSize: 15
		relatedLocationId maxSize: 15
		relatedLocationName nullable: true
		type nullable: true, maxSize: 50
		reason nullable: true, maxSize: 50
		uniqueColumn maxSize: 82
		// createdDate unique: ["uniqueColumn"]
	}
}

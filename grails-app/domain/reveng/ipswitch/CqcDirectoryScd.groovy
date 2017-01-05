package reveng.ipswitch

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class CqcDirectoryScd implements Serializable {

	String name
	String alsoKnownAs
	String address
	String postcode
	String postcodeFixed
	String phoneNumber
	String serviceWebsite
	String serviceTypes
	String specialismsServices
	String providerName
	String localAuthority
	String region
	String locationUrl
	String cqcLocation
	String cqcProviderId
	Integer sourceDataDuplicateUniquifier
	String uniqueColumn
	Integer inSourceData
	Date importDate
	Date createdDate
	Integer isLatest
	Date effectiveFrom
	Date effectiveTo
	Long char8AsciiIndex

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append name
		builder.append alsoKnownAs
		builder.append address
		builder.append postcode
		builder.append postcodeFixed
		builder.append phoneNumber
		builder.append serviceWebsite
		builder.append serviceTypes
		builder.append specialismsServices
		builder.append providerName
		builder.append localAuthority
		builder.append region
		builder.append locationUrl
		builder.append cqcLocation
		builder.append cqcProviderId
		builder.append sourceDataDuplicateUniquifier
		builder.append uniqueColumn
		builder.append inSourceData
		builder.append importDate
		builder.append createdDate
		builder.append isLatest
		builder.append effectiveFrom
		builder.append effectiveTo
		builder.append char8AsciiIndex
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append name, other.name
		builder.append alsoKnownAs, other.alsoKnownAs
		builder.append address, other.address
		builder.append postcode, other.postcode
		builder.append postcodeFixed, other.postcodeFixed
		builder.append phoneNumber, other.phoneNumber
		builder.append serviceWebsite, other.serviceWebsite
		builder.append serviceTypes, other.serviceTypes
		builder.append specialismsServices, other.specialismsServices
		builder.append providerName, other.providerName
		builder.append localAuthority, other.localAuthority
		builder.append region, other.region
		builder.append locationUrl, other.locationUrl
		builder.append cqcLocation, other.cqcLocation
		builder.append cqcProviderId, other.cqcProviderId
		builder.append sourceDataDuplicateUniquifier, other.sourceDataDuplicateUniquifier
		builder.append uniqueColumn, other.uniqueColumn
		builder.append inSourceData, other.inSourceData
		builder.append importDate, other.importDate
		builder.append createdDate, other.createdDate
		builder.append isLatest, other.isLatest
		builder.append effectiveFrom, other.effectiveFrom
		builder.append effectiveTo, other.effectiveTo
		builder.append char8AsciiIndex, other.char8AsciiIndex
		builder.isEquals()
	}

	static mapping = {
		id composite: ["name", "alsoKnownAs", "address", "postcode", "postcodeFixed", "phoneNumber", "serviceWebsite", "serviceTypes", "specialismsServices", "providerName", "localAuthority", "region", "locationUrl", "cqcLocation", "cqcProviderId", "sourceDataDuplicateUniquifier", "uniqueColumn", "inSourceData", "importDate", "createdDate", "isLatest", "effectiveFrom", "effectiveTo", "char8AsciiIndex"]
		version false
        char8AsciiIndex column: 'Char_8_ASCII_Index'
	}

	static constraints = {
		alsoKnownAs nullable: true
		address nullable: true
		postcode maxSize: 50
		postcodeFixed maxSize: 8
		phoneNumber nullable: true, maxSize: 50
		serviceWebsite nullable: true
		serviceTypes nullable: true, maxSize: 4000
		specialismsServices nullable: true, maxSize: 4000
		localAuthority nullable: true, maxSize: 50
		region nullable: true, maxSize: 50
		cqcLocation maxSize: 50
		cqcProviderId maxSize: 50
		uniqueColumn nullable: true, maxSize: 156
		effectiveFrom nullable: true
		effectiveTo nullable: true// , unique: ["uniqueColumn"]
		char8AsciiIndex nullable: true
	}
}

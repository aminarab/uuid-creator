package com.github.f4b6a3.uuid.creator.rfc4122;

import org.junit.Test;

import com.github.f4b6a3.uuid.UuidCreator;
import com.github.f4b6a3.uuid.creator.AbstractUuidCreatorTest;
import com.github.f4b6a3.uuid.creator.rfc4122.NameBasedSha1UuidCreator;
import com.github.f4b6a3.uuid.enums.UuidNamespace;
import com.github.f4b6a3.uuid.enums.UuidVersion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

public class NameBasedSha1UuidCreatorTest extends AbstractUuidCreatorTest {

	@Test
	public void testNameBasedSha1Uuid() {

		UUID[] list = new UUID[DEFAULT_LOOP_MAX];
		NameBasedSha1UuidCreator creator = UuidCreator.getNameBasedSha1Creator();

		String name;

		for (int i = 0; i < DEFAULT_LOOP_MAX; i++) {
			name = ("url" + i);
			list[i] = creator.create(UuidNamespace.NAMESPACE_URL, name);
		}

		checkNullOrInvalid(list);
		checkUniqueness(list);
		checkVersion(list, UuidVersion.VERSION_NAMBE_BASED_SHA1.getValue());

		for (int i = 0; i < DEFAULT_LOOP_MAX; i++) {
			name = ("url" + i);
			UUID other = creator.create(UuidNamespace.NAMESPACE_URL, name);
			assertTrue("Two different SHA1 UUIDs for the same input", list[i].equals(other));
		}
	}

	@Test
	public void testGetNameBasedSha1NamespaceUrlAndSiteGithub() {

		UuidNamespace namespace = UuidNamespace.NAMESPACE_DNS;
		String name = GITHUB_URL;

		String uuidString1 = "a2999f4b-523d-5e63-866a-d0d9f401fe93"; // generated by SHA1SUM (gnu-coreutils)
		String uuidString2 = "04e16ed4-cd93-55f3-b2e3-1a097fc19832"; // generated by UUIDGEN (util-linux)

		UUID uuid3 = UUID.fromString(uuidString1);
		UUID uuid4 = UuidCreator.getNameBasedSha1(name);
		assertEquals(uuid3, uuid4);

		UUID uuid1 = UUID.fromString(uuidString2);
		UUID uuid2 = UuidCreator.getNameBasedSha1(namespace, name);
		assertEquals(uuid1, uuid2);

		NameBasedSha1UuidCreator creator1 = UuidCreator.getNameBasedSha1Creator().withNamespace(namespace);
		UUID uuid5 = UUID.fromString(uuidString2);
		UUID uuid6 = creator1.create(name);
		assertEquals(uuid5, uuid6);
	}
}

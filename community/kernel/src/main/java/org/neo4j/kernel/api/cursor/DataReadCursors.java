/*
 * Copyright (c) 2002-2015 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
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
 */
package org.neo4j.kernel.api.cursor;

import org.neo4j.kernel.api.exceptions.index.IndexNotFoundKernelException;
import org.neo4j.kernel.api.exceptions.schema.IndexBrokenKernelException;
import org.neo4j.kernel.api.index.IndexDescriptor;

/**
 * Reading data through cursors. This allows clients to both create cursors and
 * attach them to iterations of nodes and relations.
 */
public interface DataReadCursors
{
    NodeCursor nodeCursor( long nodeId );

    RelationshipCursor relationshipCursor( long relId );

    NodeCursor nodeCursorGetAll();

    RelationshipCursor relationshipCursorGetAll();

    NodeCursor nodeCursorGetForLabel( int labelId );

    NodeCursor nodeCursorGetFromIndexSeek( IndexDescriptor index, Object value )
            throws IndexNotFoundKernelException;

    NodeCursor nodeCursorGetFromIndexByPrefixSearch( IndexDescriptor index, String prefix )
            throws IndexNotFoundKernelException;

    NodeCursor nodeCursorGetFromIndexScan( IndexDescriptor index )
            throws IndexNotFoundKernelException;

    NodeCursor nodeCursorGetFromUniqueIndexSeek( IndexDescriptor index, Object value )
            throws IndexNotFoundKernelException, IndexBrokenKernelException;

}

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.jena.sparql.algebra;

import org.apache.jena.sparql.algebra.op.*;

public interface OpVisitor
{
    // Op0
    public void visit(OpBGP opBGP);
    public void visit(OpQuadPattern quadPattern);
    public void visit(OpQuadBlock quadBlock);
    public void visit(OpTriple opTriple);
    public void visit(OpQuad opQuad);
    public void visit(OpPath opPath);
    public void visit(OpTable opTable);
    public void visit(OpNull opNull);

    //Op1
    public void visit(OpProcedure opProc);
    public void visit(OpPropFunc opPropFunc);
    public void visit(OpFilter opFilter);
    public void visit(OpGraph opGraph);
    public void visit(OpService opService);
    public void visit(OpDatasetNames dsNames);
    public void visit(OpLabel opLabel);
    public void visit(OpAssign opAssign);
    public void visit(OpExtend opExtend);
    public void visit(OpUnfold opUnfold);

    // Op2
    public void visit(OpJoin opJoin);
    public void visit(OpLeftJoin opLeftJoin);
    public void visit(OpUnion opUnion);
    public void visit(OpMinus opMinus);
    public void visit(OpConditional opCondition);
    public void visit(OpLateral opLateral);
    public void visit(OpSemiJoin opSemiJoin);
    public void visit(OpAntiJoin opAntiJoin);

    // OpN
    public void visit(OpSequence opSequence);
    public void visit(OpDisjunction opDisjunction);

    public default void visit(OpExt opExt) {
        Op effective = opExt.effectiveOp();
        if (effective != null)
            effective.visit(this);
    }

    // OpModifier
    public void visit(OpList opList);
    public void visit(OpOrder opOrder);
    public void visit(OpProject opProject);
    public void visit(OpReduced opReduced);
    public void visit(OpDistinct opDistinct);
    public void visit(OpSlice opSlice);

    public void visit(OpGroup opGroup);
    public void visit(OpTopN opTop);
}

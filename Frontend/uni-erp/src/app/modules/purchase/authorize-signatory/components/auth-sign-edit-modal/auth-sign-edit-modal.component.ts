import { AuthorizeLvl } from './../../../../../core/models/Purchase/authorizelvl';
import { AuthorizeSignatory } from './../../../../../core/models/Purchase/authorize-signatory';
import { Component, OnInit, Input } from '@angular/core';
import { NzModalRef, NzMessageService } from 'ng-zorro-antd';
import { AuthLvlAddModalComponent } from '../../../authorize-lvl/components/auth-lvl-add-modal/auth-lvl-add-modal.component';
import { AuthorizeSignatoryService } from 'src/app/core/services/Purchase/authorize-signatory.service';
import { AuthorizeLvlService } from 'src/app/core/services/Purchase/authorize-lvl.service';

@Component({
  selector: 'app-auth-sign-edit-modal',
  templateUrl: './auth-sign-edit-modal.component.html',
  styleUrls: ['./auth-sign-edit-modal.component.less']
})
export class AuthSignEditModalComponent implements OnInit {

	@Input() authSign: AuthorizeSignatory;
	authLvls: any = [];

  constructor(
		private authSignService: AuthorizeSignatoryService,
		private modalRef: NzModalRef<AuthLvlAddModalComponent>,
		private message: NzMessageService,
		private authLvlService: AuthorizeLvlService
	) { }

  ngOnInit() {
		this.getAllAuthLvl();

		// console.log(this.authLvl);
  }

	onCancel() {
		this.modalRef.triggerCancel();
	}

	updateAuthSign(){
		this.authSignService.updateAuthSign(this.authSign.id, this.authSign).subscribe(
			data => {
				this.message.create('success', `Authorize Signatory Updated Successfully!`,{nzDuration:3000});
				// console.log(JSON.parse(JSON.stringify(this.authLvl)))
				this.modalRef.triggerOk();
			},
			error => {
				this.message.create('error', `Authorize Signatory Not Updated!`,{nzDuration:3000});
			}
		);

		// this.modalRef.close();
	}

	public getAllAuthLvl(){
		this.authLvlService.getAllAuthLvl().subscribe(
				data => {
						this.authLvls = data;


				},
				error => {

					if(error['status']=='404'){
						this.authLvls = [];
					}
						else if(error.error){
						this.authLvls = error.error;
				}



				}
		);
	}
}
